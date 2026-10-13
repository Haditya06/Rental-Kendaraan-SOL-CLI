package view;

import java.util.List;
import java.util.Scanner;
import model.Kendaraan;
import model.Penyewaan;
//import model.Kendaraan;

public class RentalView {
    private final Scanner scanner = new Scanner(System.in);

    public String tampilMenu() {
        System.out.println("======= RENTAL KENDARAAN =======");
        System.out.println("1. List Daftar Kendaraan");
        System.out.println("2. Tambah Kendaraan");
        System.out.println("3. Sewa Kendaraan");
        System.out.println("4. Kembalikan Kendaraan");
        System.out.println("5. Riwayat Penyewaan");
        System.out.println("0. Keluar");
        System.out.print("Pilih menu: ");
        return scanner.nextLine();
    }

    public void tampilDaftarKendaraan(List<Kendaraan> daftar) {
        System.out.println("======= DAFTAR KENDARAAN =======");
        if (daftar.isEmpty()) {
            System.out.println("Belum ada kendaraan yang terdaftar.");
            return;
        }
        for (Kendaraan k : daftar) {
            System.out.println(k.getPlatNomor() + " | " + k.getMerk() + " | " +
             k.getJenis() + " | " + Format.rupiah(k.getTarifPerHari())+ " | " + 
             (k.isAktif() ? "Tersedia" : "Disewa"));
        }
    }
    public void tampilRiwayat(List<Penyewaan> daftar) {
        System.out.println("======= RIWAYAT PENYEWAAN =======");
        if (daftar.isEmpty()) {
            System.out.println("Belum ada riwayat penyewaan.");
            return;
        }
        for (Penyewaan p : daftar) {
            System.out.println(p.getId() + " | " + p.getNamaPenyewa() + " | " +
             p.getKendaraan().getMerk() + " | " + p.getLamaHari() + " | " + Format.rupiah(p.getTotalBiaya()) + " | " 
             + (p.isAktif() ? "Berjalan" : "Selesai"));
        }
    }

    public String bacaTeks(String label) {
        System.out.print(label + ": ");
        return scanner.nextLine().trim();
    }

    public long bacaAngka(String label) {
        while (true) {
            String teks = bacaTeks(label);
            try {
                return Long.parseLong(teks);
            } catch (NumberFormatException e) {
                tampilPesan("Input harus berupa angka. Silakan coba lagi.");
            }
        }
    }

    public void tampilPesan(String pesan) {
        System.out.println(">> " + pesan);
    }
}
