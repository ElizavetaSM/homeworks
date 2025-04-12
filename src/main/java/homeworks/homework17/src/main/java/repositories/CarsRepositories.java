package repositories;


import model.Car;

import java.util.List;

public interface CarsRepositories {
    List<Car> getAllCars();
    void addCar(Car car);
    void removeCar(Car car);
}
