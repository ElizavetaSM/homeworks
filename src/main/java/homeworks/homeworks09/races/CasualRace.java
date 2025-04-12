package homeworks.homeworks09.races;

import homeworks.homeworks09.cars.Car;

public class CasualRace extends Race{
    public CasualRace(int routeLenght, String route, int prizeFund, Car[] carsGallery) {
        super(routeLenght, route, prizeFund, carsGallery);
    }

    public CasualRace() {
    }

    @Override
    public String toString() {
        return "CasualRace{} " + super.toString();
    }
}