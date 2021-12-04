package free.course.week3;

import java.util.ArrayList;
import java.util.List;

public class LottoSeller {

    public static List<LottoTicket> sellLottoTicketByPrice(int price) {
        List<LottoTicket> lottoTicketList = new ArrayList<>();

        if(price > 0) createAndAddLottoTicket(price, lottoTicketList);

        return lottoTicketList;
    }

    private static void createAndAddLottoTicket(int price, List<LottoTicket> lottoTicketList) {
        for (int i = 0; i < price / 1000; i++) {
            lottoTicketList.add(LottoTicket.generateLottoTicket());
        }
    }
}
