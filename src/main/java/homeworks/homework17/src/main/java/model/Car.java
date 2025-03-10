package model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Getter

public class Car { //характеристики авто
    private String brand;
    private String model;
    private int yearOfRelease;
    private int horsePower;
    private int acceleration;
    private int suspension;
    private int durability;

    public  Car (String line) {
        String [] elements = line.split(",");
        this.brand = elements [0].trim();
        this.model = elements [1].trim();
        this.yearOfRelease = Integer.parseInt(elements [2].trim());
        this.horsePower = Integer.parseInt(elements [3].trim());
        this.acceleration = Integer.parseInt(elements [4].trim());
        this.suspension = Integer.parseInt(elements [5].trim());
        this.durability = Integer.parseInt(elements [6].trim());
    }



}
