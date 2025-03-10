
import model.Car;
import model.PerformanceCar;
import repositories.CarsRepositories;
import repositories.impl.CarsRepositoriesFileImpl;

import java.util.List;


public class App {
    public static void main(String[] args) {
        CarsRepositories repository = new CarsRepositoriesFileImpl();

        List<Car> cars = repository.getAllCars();
        for (Car car : cars) {
            System.out.println(car);
        }

        PerformanceCar newPerformanceCar = new PerformanceCar("Audi, R8, 2001, 600, 3, 2, 10", new String[]{"Spoiler", "Sunroof"});
        repository.addCar(newPerformanceCar);

        cars = repository.getAllCars();
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}

