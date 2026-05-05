//1

123456789

}

class Vehicle {

void speedUp() { System.out.println("Vehicle accelerating"); }

class Car extends Vehicle {

@Override

void speedUp() { System.out.println("Car accelerating by 22 units"); }

void drift() { System.out.println("Performing a drift!"); }

public class Main (

public static void main(String[] args) {

Vehicle myVehicle new Car(); upcasting

myVehicle.speedup();

/*Pertanyaan Analisis:

Mengapa metode drift() tidak dapat dipanggil melalui variabel myVehicle padahal objek aktualnya adalah Car?

Tuliskan blok kode perbaikan menggunakan operator instanceof dan Downcasting yang aman untuk memanggil drift).

2.⁠ ⁠Amati skenario overloading pada kelas berikut:

//Jawaban:

if (myVehicle instanceof Car) {
    Car myCar = (Car) myVehicle; // Downcasting
    myCar.drift();
}




