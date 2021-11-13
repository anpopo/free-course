package free.course.week2;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class CarsFactory {
    public static GameJoinedCars createGameJoinedCars(List<String> carNames) {
        return new GameJoinedCars(
                carNames.stream()
                .map(car -> {
                    Optional<Car> createdCar = Car.validCarNameAndSetName(car);
                    return createdCar.orElse(null);
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList())
        );
    }
}
