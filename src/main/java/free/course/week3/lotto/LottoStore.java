package free.course.week3.lotto;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class LottoStore implements Store {

    public static final int LOTTO_PRICE = 1000;
    private Long id;
    private String lottoStoreName;
    private String lottoStoreLocation;
    private boolean approval;

    private LottoGenerateMachine lottoGenerateMachine;

    private LottoStore () {}

    LottoStore(boolean governmentApproval) {
        if(!governmentApproval) throw new RuntimeException("정부 허가 없이 복권 가게를 차릴 수 없습니다.");
        this.id = (long) UUID.randomUUID().toString().hashCode();
    }

    public static LottoStore createLottoStoreByApproval(boolean governmentApproval) {
        LottoStore lottoStore = new LottoStore(governmentApproval);
        lottoStore.approval = true;
        lottoStore.lottoGenerateMachine = new LottoGenerateMachine(lottoStore);
        return lottoStore;
    }

    @Override
    public Lotto sell (int money) {
        if(money < LOTTO_PRICE) throw new RuntimeException("최소 가격이 부족합니다.");
        return lottoGenerateMachine.createLotto(this, money / LOTTO_PRICE);
    }

    @Override
    public LottoResult getResult() {
        return null;
    }

    public Long getId() {
        return this.id;
    }

    public boolean isApproval() {
        return approval;
    }
}
