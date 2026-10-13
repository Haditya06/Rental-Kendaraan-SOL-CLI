package view;

import java.util.Locale;
//[SRP] satu tanggung jawab: memformat angka menjadi reks rupiah
public class Format {

    public static String rupiah(long nilai) {
        return String.format(Locale.US, "Rp%,d", nilai).replace(",", ".");
    }

}
