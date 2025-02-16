package homeworks.homework09.races;

import homeworks.homework09.cars.Car;

public class DragRace extends Race {
    public DragRace(int routeLenght, String route, int prizeFund, Car[] carsGallery) {
        super(routeLenght, route, prizeFund, carsGallery);
    }

    public DragRace() {
    }

    @Override
    public String toString() {
        return "DragRace{} " + super.toString();
    }
}
