package free.course.racing.common;

import free.course.racing.Players;
import free.course.racing.domain.RacingCar;
import free.course.racing.domain.RacingCarFactory;
import free.course.racing.exception.InvalidNameException;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class Game {
    private final CustomPrinter customPrinter = new CustomPrinter();
    private final CustomInput customInput = new CustomInput();

    private Players players;
    private int round;

    private Game() {}

    public static void playGame(){
        Game game = new Game();

        game.getPlayerInfo();
        game.getPlayRound();
    }
    private void getPlayerInfo() {
        do {
            playerInfoTaking();
        }
        while (Objects.isNull(players.getRacingCars()));
    }

    private void playerInfoTaking() {
        customPrinter.printPlayerInput();
        try {
            players = RacingCarFactory.createRacingCars(customInput.getInput());
        } catch (InvalidNameException | IOException e) {
            customPrinter.errorWhileInput();
        }
    }

    private void getPlayRound() {
        do {
            roundTaking();
        } while (round < 1);
    }

    private void roundTaking() {
        customPrinter.printRoundInput();
        try {
            round = Integer.parseInt(customInput.getInput());
        } catch (NumberFormatException | IOException e) {
            customPrinter.errorWhileInput();
            return;
        }

        if (round < 1) customPrinter.errorWhileInput();
    }
}
