public class LayananEkspedisi {
    // Disini menggunakan access modifier protected agar atribut ini bisa diturunkan 
    // dan bisa diakses langsung oleh subclass-nya.
    protected String nomorResi;
    protected double beratAktualKg;
    protected double panjang;
    protected double lebar;
    protected double tinggi;

    // Konstruktor untuk menginisialisasi semua atribut
    public LayananEkspedisi(String nomorResi, double beratAktualKg, double panjang, double lebar, double tinggi) {
        this.nomorResi = nomorResi;
        this.beratAktualKg = beratAktualKg;
        this.panjang = panjang;
        this.lebar = lebar;
        this.tinggi = tinggi;
    }

    // Metode mengembalikan nilai tertinggi antara berat aktual dan berat volumetrik
    public double hitungBeratEfektif() {
        // Rumus volumetrik = (P x L x T) / 6000
        double beratVolumetrik = (panjang * lebar * tinggi) / 6000.0;
        return Math.max(beratAktualKg, beratVolumetrik);
    }

    // Metode mencetak nomor resi dan Berat Efektif
    public void cetakResi() {
        System.out.println("Nomor Resi: " + nomorResi + " | Berat Efektif: " + hitungBeratEfektif() + " kg");
    }

    // Metode polymorphic yang mengembalikan 0.0, nantinya akan di override
    public double hitungOngkir() {
        return 0.0;
    }
}