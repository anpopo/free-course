package free.course.racing.domain;

public class RacingCar {


    private String racingCarName;

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
}
