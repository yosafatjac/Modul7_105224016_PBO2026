import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Buat ArrayList (Upcasting)
        ArrayList<LayananEkspedisi> daftarPaket = new ArrayList<>();

        // Tambahkan data ke dalam koleksi
        daftarPaket.add(new LayananReguler("REG-11", 2, 50, 50, 50)); 
        daftarPaket.add(new LayananExpress("EXP-22", 5, 10, 10, 10)); 
        daftarPaket.add(new LayananInternasional("INT-33", 3, 20, 20, 20, "Korea", 100)); 

        double totalPendapatanPerusahaan = 0.0;

        System.out.println("=== Sistem Ekspedisi Modul 7 ===");

        for (LayananEkspedisi paket : daftarPaket) {
            System.out.println("----------------------------------------");
            
            paket.cetakResi();

            //Kita tambahkan hasil ongkir dasar ke total pendapatan
            double ongkirDasar = paket.hitungOngkir();
            totalPendapatanPerusahaan += ongkirDasar;
            System.out.println("Ongkir Dasar: Rp " + ongkirDasar);

            // Gunakan instanceof dan Downcasting
            if (paket instanceof LayananReguler) {
                LayananReguler reguler = (LayananReguler) paket;
                double ongkirFinal = reguler.hitungOngkir(true, 25);
                System.out.println("Ongkir Akhir (Diskon Member & Jarak): Rp " + ongkirFinal);

            } else if (paket instanceof LayananExpress) {
                LayananExpress express = (LayananExpress) paket;
                express.klaimAsuransi(1500000);
                
            } else if (paket instanceof LayananInternasional) {
                LayananInternasional internasional = (LayananInternasional) paket;
                internasional.cetakManifest();
            }
        }
        // Cetak total pendapatan perusahaan dari ongkir dasar
        System.out.println("========================================");
        System.out.println("Total Pendapatan Perusahaan (Ongkir Dasar): Rp " + totalPendapatanPerusahaan);
    }
}