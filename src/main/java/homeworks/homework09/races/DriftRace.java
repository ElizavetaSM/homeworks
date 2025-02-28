package homeworks.homework09.races;

import homeworks.homework09.cars.Car;

public class DriftRace extends Race{
    public DriftRace(int routeLenght, String route, int prizeFund, Car[] carsGallery) {
        super(routeLenght, route, prizeFund, carsGallery);
    }

    public DriftRace() {
    }

    @Override
    public String toString() {
        return "DriftRace{} " + super.toString();
    }
}
