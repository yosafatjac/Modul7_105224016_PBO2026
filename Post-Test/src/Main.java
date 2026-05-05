import java.util.ArrayList;

// No 1 Superclass
class MetodePembayaran {
    public void bayar(double nominal) {
        System.out.println("Memproses pembayaran umum sebesar Rp" + nominal + "...");
    }
}

// No 2 Subclass EWallet
class EWallet extends MetodePembayaran {

    @Override // No 2: Overriding
    public void bayar(double nominal) {
        System.out.println("Memotong saldo E-Wallet sebesar Rp" + nominal + "...");
    }

    // No 2 Overloading dan tambah parameter nomorHp
    public void bayar(double nominal, String nomorHp) {
        System.out.println("Memotong saldo E-Wallet sebesar Rp" + nominal
            + " dari nomor " + nomorHp + "...");
    }
}

// No 3 Subclass KartuKredit
class KartuKredit extends MetodePembayaran {

    @Override //No 3 Overriding
    public void bayar(double nominal) {
        System.out.println("Mencetak tagihan Kartu Kredit sebesar Rp" + nominal + "...");
    }

    // No 3 Metode unik KartuKredit
    public void verifikasiPIN() {
        System.out.println("Memverifikasi PIN Kartu Kredit... BERHASIL!");
    }
}

// No 4 Kelas Main
public class Main {
    public static void main(String[] args) {

        // No 4: ArrayList + Upcasting
        ArrayList<MetodePembayaran> listPembayaran = new ArrayList<>();
        listPembayaran.add(new EWallet());      
        listPembayaran.add(new KartuKredit());  

        // No 4 Looping dengan 3 hal di dalamnya
        for (MetodePembayaran m : listPembayaran) {

            // Panggil bayar(100000) dan Runtime Polymorphism
            m.bayar(100000);

            // Jika EWallet = Downcast serta panggil overloading bayar dengan nomorHp
            if (m instanceof EWallet) {
                EWallet ew = (EWallet) m;               
                ew.bayar(100000, "08123456789");       
            }

            //Jika KartuKredit = Downcast + panggil verifikasiPIN()
            if (m instanceof KartuKredit) {
                KartuKredit kk = (KartuKredit) m;      
                kk.verifikasiPIN();
            }
        }
    }
}
