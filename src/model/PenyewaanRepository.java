package model;

import java.util.ArrayList;
import java.util.List;

public class PenyewaanRepository {
    private final List<Penyewaan> data = new ArrayList<>();

    public String buatId() {
        return String.format("SW-%03d", data.size() + 1);
    }

    public void tambah(Penyewaan penyewaan) {
        data.add(penyewaan);
    }

    public List<Penyewaan> semua() {
        return new ArrayList<>(data);
    }

    public Penyewaan cariAktifByPlat(String platNomor) {
        for (Penyewaan p : data) {
            if (p.getKendaraan().getPlatNomor().equalsIgnoreCase(platNomor) && p.isAktif()) {
                return p;
            }
        }
        return null;
    }

}
