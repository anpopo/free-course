package free.course.racing.domain;

import free.course.racing.util.RandomNumberGenerator;

import java.util.Objects;

public class RacingCar {
    private String racingCarName;
    private int goCount;

    private RacingCar () {}

    private RacingCar(String racingCarName) {
        this.racingCarName = racingCarName;
    }

    public static RacingCar createRacingCar(String racingCarName) {
        return new RacingCar(racingCarName);
    }

    public String getRacingCarName() {
        return racingCarName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return Objects.equals(racingCarName, racingCar.racingCarName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racingCarName);
    }

    public void goOrStop() {
        int std = RandomNumberGenerator.getRandomNumber();
        if (std > 3) goCount++;
    }

    public int getGoCount() {
        return goCount;
    }
}
