package free.course.week3.lotto;

public class LottoGenerateMachine {

    private Long lottoGenerateMachineId;

    private LottoGenerateMachine() {}

    public LottoGenerateMachine(LottoStore lottoStore) {
        this.lottoGenerateMachineId = lottoStore.getId();
    }

    Lotto createLotto(LottoStore lottoStore, int count) {
        assert lottoStore.isApproval() && this.lottoGenerateMachineId.equals(lottoStore.getId());
        return this.generate(lottoStore, count);
    }

    private Lotto generate(LottoStore lottoStore, int count) {
        return new Lotto(this, lottoStore, count);
    }

    public Long getLottoGenerateMachineId() {
        return this.lottoGenerateMachineId;
    }
}
