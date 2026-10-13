package model;

import java.util.ArrayList;
import java.util.List;

// [SRP] satu satunya tanggung jawab: menyimppan & mencari kendaraan di arraylist
// jika nantik penyimpanan data diganti, maka cukup class ini saja yang diubah, tidak perlu mengubah class lain
public class KendaraanRepository {
    private final List<Kendaraan> data = new ArrayList<>();

    public void tambah(Kendaraan kendaraan) {
        data.add(kendaraan);
    }

    public List<Kendaraan> semua() {
        return new ArrayList<>(data);
    }

    public Kendaraan cariByPlat(String platNomor) {
        for (Kendaraan k : data) {
            if (k.getPlatNomor().equalsIgnoreCase(platNomor)) {
                return k;
            }
        }
        return null;
    }

    
}
