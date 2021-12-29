package free.course.baseball.common;

import free.course.baseball.domain.BallContainer;
import free.course.baseball.domain.GameResult;
import free.course.baseball.exception.NotValidInputException;
import free.course.baseball.util.ValidationUtil;

import java.io.*;

public class Game {

    private final Printer printer = new Printer();
    private final GameResult gameResult = GameResult.of();


    public void gamePlay() throws IOException {

        BallContainer winningBallContainer = BallContainer.of();
        int matching = 0;
        do {
            BallContainer ballContainer = getClientBallContainer();

            if (ballContainer == null) continue;

            matching = printer.printResult(gameResult.matching(winningBallContainer, ballContainer));

        } while (matching < 3);

        replayGame();
    }

    private BallContainer getClientBallContainer() throws IOException {
        String inputString = printer.getInputString();
        
        BallContainer ballContainer;

        try {
            ballContainer = BallContainer.of(inputString);
        } catch (NotValidInputException e) {
            printer.notValidMessage();
            return null;
        }

        return ballContainer;
    }

    private void replayGame() throws IOException {
        String isReplay = printer.getReplayMessage();

        if (ValidationUtil.validateClientReplay(isReplay)) {
            new Game().gamePlay();
        }

        printer.close();
    }

}
