public class LayananReguler extends LayananEkspedisi {

    public LayananReguler(String nomorResi, double beratAktualKg, double panjang, double lebar, double tinggi) {
        super(nomorResi, beratAktualKg, panjang, lebar, tinggi); 
    }

    // Overriding tarif dasar Rp 15.000 per Kg
    @Override
    public double hitungOngkir() {
        return hitungBeratEfektif() * 15000.0;
    }

    // Overloading metode hitungOngkir dengan parameter khusus
    public double hitungOngkir(boolean isMember, int jarakKm) {
        double tarifDasar = hitungOngkir(); 
        
        if (isMember) {
            tarifDasar = tarifDasar - (tarifDasar * 0.10); // Diskon 10%
        }
        
        double surcharge = jarakKm * 500.0; // Surcharge Rp 500 per jarakKm
        return tarifDasar + surcharge;
    }
}