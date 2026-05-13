public class LayananInternasional extends LayananEkspedisi {
    private String negaraTujuan;
    private double nilaiBarangUSD;
    
    // Untuk menginisialisasi semua atribut, termasuk yang diwariskan dari superclass
    public LayananInternasional(String nomorResi, double beratAktualKg, double panjang, double lebar, double tinggi, String negaraTujuan, double nilaiBarangUSD) {
        super(nomorResi, beratAktualKg, panjang, lebar, tinggi);
        this.negaraTujuan = negaraTujuan;
        this.nilaiBarangUSD = nilaiBarangUSD;
    }

    // Overriding untuk Tarif ongkir dasar Rp 200.000 per Kg
    @Override
    public double hitungOngkir() {
        double tarifDasar = hitungBeratEfektif() * 200000.0;
        double pajak = 0.0;
        
        // Pajak Bea Cukai 20% jika lebih dari 50 USD
        if (nilaiBarangUSD > 50) {
            pajak = tarifDasar * 0.20;
        }
        
        return tarifDasar + pajak; 
    }

    // Metode Spesifik
    public void cetakManifest() {
        System.out.println("Manifest Internasional ke " + negaraTujuan + " - Deklarasi Nilai: $" + nilaiBarangUSD);
    }
}