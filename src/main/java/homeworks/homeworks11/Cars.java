package homeworks.homeworks11;

import java.util.Arrays;
import java.util.Objects;

import static java.lang.Integer.parseInt;

public class Cars {
    private String number;
    private String model;
    private String colour;
    private int miles;
    private int price;

    public Cars (String number, String model, String colour, int miles, int price) {
        this.number = number;
        this.model = model;
        this.colour = colour;
        this.miles = miles;
        this.price = price;
    }

    public String getNumber() {
        return number;
    }


    public void setNumber(String number) {
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getMiles() {
        return miles;
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars = (Cars) o;
        return number == cars.number && miles == cars.miles && price == cars.price && Objects.equals(model, cars.model) && Objects.equals(colour, cars.colour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, model, colour, miles, price);
    }

    @Override
    public String toString() {
        return "Cars{" +
                "number=" + number +
                ", model='" + model + '\'' +
                ", colour='" + colour + '\'' +
                ", miles=" + miles +
                ", price=" + price +
                '}';
    }
}
