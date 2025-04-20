package races;


import model.Car;

public class DriftRace extends Race {
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
