package app;

import controller.RentalController;
import model.Kendaraan;

public class Main {

    public static void main(String[] args) throws Exception {
        RentalController controller = new RentalController();

        // Data awal / dummy data
        controller.tambahDataAwal(new Kendaraan("B 1234 ABC", "Toyota", "MOBIL", 200000));
        controller.tambahDataAwal(new Kendaraan("B 5678 DEF", "Honda", "MOTOR", 100000));
        controller.tambahDataAwal(new Kendaraan("B 9012 GHI", "Suzuki", "MOBIL", 150000));

        controller.jalankan();

    }

}
