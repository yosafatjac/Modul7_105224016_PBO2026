public class LayananExpress extends LayananEkspedisi {

    public LayananExpress(String nomorResi, double beratAktualKg, double panjang, double lebar, double tinggi) {
        super(nomorResi, beratAktualKg, panjang, lebar, tinggi);
    }

    // Overriding tarif dasar Rp 30.000 per Kg
    @Override
    public double hitungOngkir() {
        return hitungBeratEfektif() * 30000.0;
    }

    // Metode Spesifik untuk klaim asuransi
    public void klaimAsuransi(double nilaiBarang) {
        if (nilaiBarang > 1000000) {
            System.out.println("Klaim Asuransi VIP Rp" + nilaiBarang + " untuk resi " + nomorResi + " sedang diproses prioritas.");
        } else {
            System.out.println("Klaim Asuransi Standar diproses dalam 7 hari kerja.");
        }
    }
}