package free.course.week3;

import java.util.ArrayList;
import java.util.List;

public class LottoGameGenerator {

    protected static LottoGame createLottoGame() {
        return new LottoGame();
    }

    public static List<LottoGame> generateLottoGameByMoney(int gameCount) {
        List<LottoGame> lottoGames = new ArrayList<>();

        for(int i = 0; i < gameCount; i++) {
            lottoGames.add(createLottoGame());
        }

        return lottoGames;
    }
}
