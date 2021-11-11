package free.course.week2;

import java.util.List;
import java.util.stream.Collectors;

public class CarsFactory {
    public static List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(car -> {
                    Car newCar = new Car();
                    newCar.validCarNameAndSetName(car);
                    return newCar;
                })
                .collect(Collectors.toList());
    }
}
