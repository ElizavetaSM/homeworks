package homeworks.homeworks09.races;

import homeworks.homeworks09.cars.Car;

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
