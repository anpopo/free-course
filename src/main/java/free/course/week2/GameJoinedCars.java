package free.course.week2;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GameJoinedCars {
    private final List<Car> gameJoinedCars;

    public GameJoinedCars(List<Car> gameJoinedCars) {
        this.gameJoinedCars = gameJoinedCars;
    }


    public int getJoinedCarsCount() {
        return this.gameJoinedCars.size();
    }

    public List<Car> getJoinedCars() {
        return this.gameJoinedCars;
    }


    public List<Car> getWinnerList() {

        gameJoinedCars.sort((a, b) -> b.getGoCount() - a.getGoCount());

        int std = gameJoinedCars.get(0).getGoCount();

        return this.gameJoinedCars.stream()
                .filter(car -> car.getGoCount() == std)
                .collect(Collectors.toList());
    }
}
