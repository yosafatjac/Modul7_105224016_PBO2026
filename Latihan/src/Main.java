import java.util.ArrayList;

//No 1 Kita membuat Superclass
class PerangkatPintar {
    public void aktifkan() {
        System.out.println("Perangkat pintar diaktifkan.");
    }
}

//No 1 dan 2 Subclass LampuPintar
class LampuPintar extends PerangkatPintar {

    @Override //1 Overriding
    public void aktifkan() {
        System.out.println("Lampu menyala dengan tingkat kecerahan standar.");
    }

    //No 2 kita membuat Overloading versi 1
    public void aturKecerahan(int level) {
        System.out.println("Kecerahan lampu diatur ke level " + level + "%.");
    }

    //No 2
    public void aturKecerahan(int level, String warna) {
        System.out.println("Kecerahan lampu diatur ke level " + level
            + "% dengan warna cahaya " + warna + ".");
    }
}

class AcPintar extends PerangkatPintar {

    @Override 
    public void aktifkan() {
        System.out.println("AC menyala dan mulai mendinginkan ruangan.");
    }

    //no 4 kita tambahkan Metode unik milik AcPintar
    public void aturSuhu(int suhu) {
        System.out.println("Suhu ruangan diatur menjadi " + suhu + " derajat.");
    }
}

public class Main {
    public static void main(String[] args) {

        //No 3 ArrayList + Upcasting
        ArrayList<PerangkatPintar> perangkatList = new ArrayList<>();
        PerangkatPintar p1 = new LampuPintar(); // Upcasting
        PerangkatPintar p2 = new AcPintar();    // Upcasting
        perangkatList.add(p1);
        perangkatList.add(p2);

        //No 3 kita looping + Polimorfisme
        System.out.println("=== Mengaktifkan semua perangkat ===");
        for (PerangkatPintar p : perangkatList) {
            p.aktifkan();
        }

        //No 2 Demo Overloading
        System.out.println("\n=== Mengatur kecerahan lampu===");
        LampuPintar lampu = new LampuPintar();
        lampu.aturKecerahan(75);
        lampu.aturKecerahan(50, "kuning hangat");

        //No 4 instanceof + Downcasting dan panggil aturSuhu(20)
        System.out.println("\n=== Mengatur suhu AC ===");
        for (PerangkatPintar p : perangkatList) {
            if (p instanceof AcPintar) {    
                AcPintar ac = (AcPintar) p;
                ac.aturSuhu(20);           
            }
        }

        //No 5 kita Fix dan Downcast dulu ke LampuPintar sebelum panggil aturKecerahan()
        PerangkatPintar alat1 = new LampuPintar(); 
    
        LampuPintar alat1Fix = (LampuPintar) alat1; 
        alat1Fix.aturKecerahan(75, "Putih");         
    }
}


/*

Nomor 5

Tugas Analisis: Berdasarkan pemahaman Anda mengenai resolusi metode pada
Polymorphism, jelaskan mengapa error ini terjadil Bagaimana cara memperbaiki bariş kode tersebut.

Jawaban: Karena Java mengecek metode berdasarkan tipe referensi variabel, bukan objek aslinya. Variabel alat1 bertipe PerangkatPintar, dan PerangkatPintar tidak punya metode aturKecerahan() → compiler langsung error.
Cara fix: Downcast dulu ke LampuPintar, baru panggil aturKecerahan().

*/