package free.course.week3;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {

    private final List<LottoGame> lottoGames;

    public LottoTicket(List<LottoGame> lottoGames) {
        this.lottoGames = lottoGames;
    }

    public List<LottoGame> getLottoGames() {
        return new ArrayList<>(this.lottoGames);
    }

}
