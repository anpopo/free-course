package free.course.racing;

import free.course.racing.domain.RacingCar;

import java.util.ArrayList;
import java.util.List;

public class Players {

    private List<RacingCar> racingCars;

    private Players () {}

    private Players(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public static Players registerPlayer(List<RacingCar> racingCars) {
        return new Players(racingCars);
    }

    public List<RacingCar> getRacingCars() {
        return new ArrayList<>(this.racingCars);
    }

    public void goOrStop() {
        for (RacingCar car : racingCars) {
            car.goOrStop();
        }
    }
}
