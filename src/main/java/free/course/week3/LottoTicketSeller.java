package free.course.week3;

import java.util.List;

public class LottoTicketSeller {
    public static LottoTicket sellLottoTicket(int cost) {
        if(cost < 1000) throw new RuntimeException("not enough money");
        if(cost > 100_000) throw new RuntimeException("maximum 100,000 won");

        List<LottoGame> lottoGames = LottoGameGenerator.generateLottoGameByMoney(cost / 1000);

        return new LottoTicket(lottoGames);
    }
}
