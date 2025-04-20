package repositories.impl;

import model.Car;
import repositories.CarsRepositories;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarsRepositoriesFileImpl implements CarsRepositories {
    private static final List <Car> CARS = new ArrayList<>();
    private static final String FILE_PATH = "src/main/resources/outputCars.txt";

    @Override
    public List<Car> getAllCars() {
        if (CARS.isEmpty()) {
            try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/inputCars.txt"))){
                List<Car> carsFromFile  = br.lines()
                        .map(Car::new)
                        .toList();
                CARS.addAll(carsFromFile);
                return CARS;
            }
            catch (IOException e) {
                System.out.println("Ошибка чтения файла:" + e.getMessage());
                return Collections.emptyList();
            }
        }
        return CARS;

    }
    @Override
    public void addCar(Car car) {
        CARS.add(car);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            bw.write(car.toString());
            bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeCar(Car car) {
        CARS.clear();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Car c : CARS) {
                bw.write(c.getModel());
                bw.newLine();}
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


