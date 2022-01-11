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
    private int max;

    private Game() {}

    public static void playGame(){
        Game game = new Game();

        game.getPlayerInfo();
        game.getPlayRound();
        System.out.println("실행결과");
        for (int i = 0; i < game.getRound(); i++) {
            game.players.goOrStop();
            game.getCustomPrinter().printGoCount(game.getPlayers());
            System.out.println();
        }
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

    public CustomPrinter getCustomPrinter() {
        return customPrinter;
    }

    public CustomInput getCustomInput() {
        return customInput;
    }

    public Players getPlayers() {
        return players;
    }

    public int getRound() {
        return round;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
