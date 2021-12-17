package free.course.week3.lotto;


import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private Long id;
    private LottoStore lottoStore;
    private int gameCount;
    private List<LottoLine> lottoLines;
    private Long lottoGenerateMachineId;

    private Lotto () {}

    Lotto(LottoGenerateMachine lottoGenerateMachine, LottoStore lottoStore, int count) {
        this.lottoGenerateMachineId = lottoGenerateMachine.getLottoGenerateMachineId();
        this.setLottoStore(lottoStore);
        this.createLottoGameByCount(count);
    }

    private void setLottoStore(LottoStore lottoStore) {
        this.lottoStore = lottoStore;
    }

    private void createLottoGameByCount(int count) {
        this.gameCount = count;

        List<LottoLine> lottoLines = new ArrayList<>();

        for(int i = 0; i < count; i++)
            lottoLines.add(LottoLine.generateLottoLine());

        this.lottoLines = lottoLines;
    }

    public int getGameCount() {
        return this.gameCount;
    }

    public List<LottoLine> getLottoLines() {
        return new ArrayList<>(this.lottoLines);
    }
}
