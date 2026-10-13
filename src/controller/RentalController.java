package controller;

import model.Kendaraan;
import model.KendaraanRepository;
import model.Penyewaan;
import model.PenyewaanRepository;
import view.RentalView;
import view.StrukView;

public class RentalController {
    private final KendaraanRepository kendaraanRepo = new KendaraanRepository();
    private final PenyewaanRepository penyewaanRepo = new PenyewaanRepository();
    private final RentalView view = new RentalView();
    private final StrukView strukView = new StrukView();

    public void tambahDataAwal(Kendaraan kendaraan) {
        kendaraanRepo.tambah(kendaraan);
    }

    public void jalankan() {
        while (true) {
            String pilihan = view.tampilMenu();
            switch (pilihan) {
                case "1" -> view.tampilDaftarKendaraan(kendaraanRepo.semua());
                case "2" -> tambahkanKendaraan();
                case "3" -> sewakanKendaraan();
                case "4" -> kembalikanKendaraan();
                case "5" -> view.tampilRiwayat(penyewaanRepo.semua());
                case "0" -> {
                    view.tampilPesan("Terima kasih telah menggunakan aplikasi ini");
                    return;
                }
                default -> view.tampilPesan("Pilihan tidak valid");
            }
        }
    }

    public void tambahkanKendaraan() {
        String plat = view.bacaTeks("Plat Nomor: ");
        if (plat.isEmpty() || kendaraanRepo.cariByPlat(plat) != null) {
            view.tampilPesan("Plat nomor kosong atau sudah terdaftar");
            return;
        }
        String merk = view.bacaTeks("Merk: ");
        String jenis = view.bacaTeks("Jenis: ");
        if (!jenis.equals("MOTOR") && !jenis.equals("MOBIL")) {
            view.tampilPesan("Jenis kendaraan harus MOTOR atau MOBIL");
            return;
        }
        Long tarif = view.bacaAngka("Tarif Per Hari");
        if (tarif <= 0) {
            System.out.println("Tarif per hari harus lebih dari 0");
            return;
        }
        kendaraanRepo.tambah(new Kendaraan(plat, merk, jenis, tarif));
        view.tampilPesan("Kendaraan berhasil ditambahkan");
    }

    public void sewakanKendaraan() {
        String plat = view.bacaTeks("Plat Nomer");
        Kendaraan kendaraan = kendaraanRepo.cariByPlat(plat);
        if (kendaraan == null || !kendaraan.isAktif()) {
            view.tampilPesan("Kendaraan tidak tersedia");
            return;
        }
        String nama = view.bacaTeks("Nama Penyewa");
        int hari = (int) view.bacaAngka("Lama Sewa (hari)");
        if (hari <= 1) {
            view.tampilPesan("Lama sewa harus lebih dari 1 hari");
            return;
        }
        long total = kendaraan.hitungBiayaSewa(hari);
        Penyewaan sewa = new Penyewaan(plat, nama, kendaraan, hari, total);
        penyewaanRepo.tambah(sewa);
        kendaraan.setTersedia(false);
        strukView.cetak(sewa);
    }

    public void kembalikanKendaraan() {
        String plat = view.bacaTeks("Plat Nomor");
        Penyewaan sewa = penyewaanRepo.cariAktifByPlat(plat);
        if (sewa == null) {
            view.tampilPesan("Tidak ada Penyewaan");
            return;
        }
        sewa.selesai();
        sewa.getKendaraan().setTersedia(true);
        view.tampilPesan("Kendaraan berhasil dikembalikan");

    }
    
}
