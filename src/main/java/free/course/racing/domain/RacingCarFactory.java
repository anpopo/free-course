package free.course.racing.domain;

import free.course.racing.Players;
import free.course.racing.exception.InvalidNameException;
import free.course.racing.util.RacingCarValidationUtil;

import java.util.ArrayList;
import java.util.List;

public class RacingCarFactory {
    private RacingCarFactory() {}

    public static Players createRacingCars(String source) throws InvalidNameException {
        List<RacingCar> racingCars = new ArrayList<>();

        for (String racingCarName : source.split(",")) {
            racingCars.add(createRacingCar(racingCarName));
        }

        if (racingCars.isEmpty()) throw new InvalidNameException("Invalid Name Set Entered!!");

        return Players.registerPlayer(racingCars);
    }

    private static RacingCar createRacingCar(String racingCarName) throws InvalidNameException {
        return RacingCar.createRacingCar(RacingCarValidationUtil.isValidName(racingCarName));
    }
}
