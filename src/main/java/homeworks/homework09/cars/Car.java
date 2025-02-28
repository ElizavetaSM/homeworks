package homeworks.homework09.cars;

import java.util.Objects;

public class Car { //характеристики авто
    private String brand;
    private String model;
    private int yearOfRelease;
    private int horsePower;
    private int acceleration;
    private int suspension;
    private int durability;

    public Car(String brand, String model, int yearOfRelease, int horsePower, int acceleration, int suspension, int durability) { // конструктур с параметрами
        this.brand = brand;
        this.model = model;
        this.yearOfRelease = yearOfRelease;
        this.horsePower = horsePower;
        this.acceleration = acceleration;
        this.suspension = suspension;
        this.durability = durability;
    }

    public Car() { //пустой конструктор
    }

    @Override
    public String toString() {
            return "Car{" +
                    "brand=" + brand +
                    ", model=" + model +
                    ", yearOfRelease=" + yearOfRelease +
                    ", horsePower=" + horsePower +
                    ", acceleration=" + acceleration +
                    ", suspension=" + suspension +
                    ", durability='" + durability + '\'' +'}';
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    public int getSuspension() {
        return suspension;
    }

    public void setSuspension(int suspension) {
        this.suspension = suspension;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return yearOfRelease == car.yearOfRelease && horsePower == car.horsePower && acceleration == car.acceleration && suspension == car.suspension && durability == car.durability && Objects.equals(brand, car.brand) && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, yearOfRelease, horsePower, acceleration, suspension, durability);
    }
}
