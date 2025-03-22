import lombok.Data;
import lombok.NoArgsConstructor;




import model.Car;
import model.PerformanceCar;


@Data
@NoArgsConstructor

public class Garage {
    private Car[] parkedCars;


    public Garage(Car[] parkedCars) {
        this.parkedCars = parkedCars;
    }


    public void modifyCar() {
        for (Car parkedCar : parkedCars) {
            if (parkedCar instanceof PerformanceCar) {
                parkedCar.setHorsePower(450);
            }
        }
    }

    public Car[] getParkedCars() {
        return parkedCars;
    }

    public void setParkedCars(Car[] parkedCars) {
        this.parkedCars = parkedCars;
    }

}
