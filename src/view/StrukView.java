package view;

import model.Penyewaan;
// [SRP] satu tanggung jawab: menampilkan struk penyewaan
public class StrukView {
    public void cetak(Penyewaan p) {
        System.out.println("---------------STRUK SEWA--------------------");
        System.out.println("ID Penyewaan :\t" + p.getId());
        System.out.println("Nama Penyewa :\t" + p.getNamaPenyewa());
        //Kendaraan : Honda Vario (L 1234 ABC)
        System.out.println("kendaraan :\t" + p.getKendaraan().getMerk() + " (" + p.getKendaraan().getPlatNomor() + ")");
        System.out.println("jenis :\t" + p.getKendaraan().getJenis());
        System.out.println("Lama Sewa :\t" + p.getLamaHari() + " hari");
        System.out.println("Total Biaya :\t" + Format.rupiah(p.getTotalBiaya()));
        System.out.println("---------------------------------------------");
        
    }
}
