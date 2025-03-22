package homeworks.homework17.src.main.java.repositories;
import model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repositories.CarsRepositories;
import repositories.impl.CarsRepositoriesFileImpl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CarsRepositoriesFileImplTest {

    private CarsRepositories carsRepositories;
    private static final String TEST_INPUT_FILE = "src/test/resources/inputCarsTest.txt";
    private static final String TEST_OUTPUT_FILE = "src/test/resources/outputCarsTest.txt";

    @BeforeEach
    public void setUp() {
        carsRepositories = new CarsRepositoriesFileImpl();
    }


    @Test
    void testGetAllCarsWhenFileHasCars() {
        addCarsToInputFile(1);
        List<Car> cars = carsRepositories.getAllCars();
        assertEquals(1, cars.size());
    }


    @Test
    void testAddCar() {
        Car newCar = new Car("Chevrolet, Impala, 1967, 600, 3, 2, 10 ");
        carsRepositories.addCar(newCar);
        List<Car> cars = carsRepositories.getAllCars();
        assertEquals(1, cars.size()); // Проверяем, что в списке один объект
        Car actualCar = cars.get(0);
        assertEquals("Chevrolet", actualCar.getBrand());
        assertEquals("Impala", actualCar.getModel());
        assertEquals(1967, actualCar.getYearOfRelease());
        assertEquals(600, actualCar.getHorsePower());
        assertEquals(3, actualCar.getAcceleration());
        assertEquals(2, actualCar.getSuspension());
        assertEquals(10, actualCar.getDurability());
    }



    private void addCarsToInputFile(int count) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(TEST_INPUT_FILE))) {
            for (int i = 0; i < count; i++) {
                bw.write("Car" + i);
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
