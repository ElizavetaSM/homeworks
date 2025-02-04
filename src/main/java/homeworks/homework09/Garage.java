package homeworks.homework09;

import homeworks.homework09.cars.Car;
import homeworks.homework09.cars.PerformanceCar;

import java.util.Arrays;
import java.util.Objects;

public class Garage {
    private Car[] parkedCars;


    public Garage(Car[] parkedCars) {
        this.parkedCars = parkedCars;
    }

    public  Garage () {

    }

    public void modifyCar () {
        for (Car parkedCar : parkedCars) {
            if (parkedCar instanceof PerformanceCar) {
                parkedCar.setHorsePower(450);
            }
        }
        }



    public Car[] getParkedCars() {
        return parkedCars;
    }

    public void setParkedCars(Car[] parkedCars) {
        this.parkedCars = parkedCars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Garage garage = (Garage) o;
        return Objects.deepEquals(parkedCars, garage.parkedCars);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(parkedCars);
    }

    @Override
    public String toString() {
        return "Garage{" +
                "parkedCars=" + Arrays.toString(parkedCars) +
                '}';
    }
}

