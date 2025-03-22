package model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Objects;
@Data
@NoArgsConstructor

public class PerformanceCar extends Car {
    private String [] addOns;

    public PerformanceCar(String line, String[] addOns) {
        super(line); // Вызываем конструктор родительского класса Car
        this.addOns = addOns;
    }}


