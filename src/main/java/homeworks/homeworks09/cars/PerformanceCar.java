package homeworks.homeworks09.cars;

import java.util.Arrays;
import java.util.Objects;

public class PerformanceCar extends Car {
    private String [] addOns;

    public PerformanceCar(String brand, String model, int yearOfRelease, int horsePower, int acceleration, int suspension, int durability, String[] addOns) {
        super(brand, model, yearOfRelease, (int) (horsePower*1.5), acceleration, (int) (suspension/0.75), durability);
        this.addOns = addOns;
    }


    public String[] getAddOns() {
        return addOns;
    }

    public void setAddOns(String[] addOns) {
        this.addOns = addOns;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PerformanceCar that = (PerformanceCar) o;
        return Objects.deepEquals(addOns, that.addOns);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Arrays.hashCode(addOns));
    }

    @Override
    public String toString() {
        return "PerformanceCar{" +
                "addOns=" + Arrays.toString(addOns) +
                "} " + super.toString();
    }
}

