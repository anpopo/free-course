package free.course.week2;

import java.util.Optional;
import java.util.Random;

public class Car {

    public static final int GO_STANDARD = 4;
    private String carName;
    private int goCount;

    private Car() {
    }

    public Car(String carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return this.carName;
    }

    public static Optional<Car> validCarNameAndSetName(String carName) {
        Car car = null;
        if(CarUtils.carNameValid(carName)) {
            car = new Car(carName);
        }
        return Optional.ofNullable(car);

    }

    public void stopOrGo() {
        int goChecker = new Random().nextInt(10);

        if(goChecker >= GO_STANDARD) {
            this.go();
        }

        printGoCount();
    }

    private void printGoCount() {
        System.out.println(this.carName + " : " + "-".repeat(Math.max(0, this.getGoCount())));
    }

    private void go() {
        this.goCount++;
    }

    public int getGoCount () {
        return this.goCount;
    }
}
