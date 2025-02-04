package homeworks.homework09;

import homeworks.homework09.cars.Car;
import homeworks.homework09.cars.PerformanceCar;
import homeworks.homework09.races.Race;


public class AppCar {
    public static void main (String [] args) {
    PerformanceCar performanceCar = new PerformanceCar("Chevrolet", "Impala", 1967, 431, 7, 2, 8, new String[2]);
    Car car1 = new Car("Chevrolet", "Camaro", 1998, 238, 5, 2, 8);
    Race race1 = new Race(4000, "LA International Speedway", 1000, new Car [2]);
    System.out.println(race1);
    Garage garage = new Garage (new Car[] {car1, performanceCar});
    garage.modifyCar();
    System.out.println(garage);


}
}