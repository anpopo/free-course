package free.course.week3;

import java.util.List;

public class LottoTicketSeller {


    public static final int LOTTO_GAME_COST = 1000;

    public static LottoTicket sellLottoTicket(int cost) {
        if(cost < 1000) throw new RuntimeException("not enough money");
        if(cost > 100_000) throw new RuntimeException("maximum 100,000 won");

        List<LottoGame> lottoGames = LottoGameGenerator.generateLottoGameByMoney(cost / LOTTO_GAME_COST);

        return new LottoTicket(lottoGames);
    }
}
