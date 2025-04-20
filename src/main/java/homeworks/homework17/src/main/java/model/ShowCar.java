package model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
@Data
@NoArgsConstructor

public class ShowCar extends Car {
    private int stars;

    public ShowCar(String line, int stars) {
        super(line); // Вызываем конструктор родительского класса Car
        this.stars = 0;
    }

}