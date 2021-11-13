package free.course.week2;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private final List<Car> winners;

    public Winners(List<Car> winners) {
        this.winners = winners;
    }

    public List<Car> getWinners() {
        return this.winners;
    }

    public int getWinnersCount() {
        return this.winners.size();
    }


    public String getWinnersName() {
        return winners.stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(","));
    }
}
