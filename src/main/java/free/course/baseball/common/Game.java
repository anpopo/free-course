package free.course.baseball.common;

import free.course.baseball.domain.BallContainer;
import free.course.baseball.exception.NotValidInputException;
import free.course.baseball.util.ValidationUtil;

import java.io.*;

public class Game {

    private final Printer printer = new Printer();


    public void gamePlay() throws IOException {

        BallContainer resultBallContainer = BallContainer.of();
        int matching = 0;
        do {

            String inputString = printer.getInputString();

            BallContainer ballContainer = null;

            try {
                ballContainer = BallContainer.of(inputString);
            } catch (NotValidInputException e) {
                printer.notValidMessage();
                continue;
            }


            matching++;

        } while(matching < 5);

        replayGame();
    }

    private void replayGame() throws IOException {
        String isReplay = printer.getReplayMessage();

        if (ValidationUtil.validateClientReplay(isReplay)) {
            new Game().gamePlay();
        }

        printer.close();
    }

}
