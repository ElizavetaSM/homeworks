package homeworks.homeworks09.races;

import homeworks.homeworks09.cars.Car;

import java.util.Arrays;
import java.util.Objects;

public class Race {
    private int routeLenght;
    private String route;
    private int prizeFund;
    private Car[] carsGallery;


    public Race(int routeLenght, String route, int prizeFund, Car[] carsGallery) {
        this.routeLenght = routeLenght;
        this.route = route;
        this.prizeFund = prizeFund;
        this.carsGallery = carsGallery;
    }

    public Race() {
    }

    @Override
    public String toString() {
        return "Race{" +
                "routeLenght=" + routeLenght +
                ", route='" + route + '\'' +
                ", prizeFund=" + prizeFund +
                ", carsGallery=" + Arrays.toString(carsGallery) +
                '}';
    }

    public int getRouteLenght() {
        return routeLenght;
    }

    public void setRouteLenght(int routeLenght) {
        this.routeLenght = routeLenght;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public int getPrizeFund() {
        return prizeFund;
    }

    public void setPrizeFund(int prizeFund) {
        this.prizeFund = prizeFund;
    }

    public Car[] getCarsGallery() {
        return carsGallery;
    }

    public void setCarsGallery(Car[] carsGallery) {
        this.carsGallery = carsGallery;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Race race = (Race) o;
        return routeLenght == race.routeLenght && prizeFund == race.prizeFund && Objects.equals(route, race.route) && Objects.deepEquals(carsGallery, race.carsGallery);
    }

    @Override
    public int hashCode() {
        return Objects.hash(routeLenght, route, prizeFund, Arrays.hashCode(carsGallery));
    }
}
