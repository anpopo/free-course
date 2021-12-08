package free.course.week3;

import java.util.Arrays;

public enum WinnerRank {
    NONE(0, 0),
    FOURTH(3, 5_000), THIRD(4, 50_000),
    SECOND(5, 1_500_000), FIRST(6, 2_000_000_000);

    private final int match;
    private final int price;

    WinnerRank(int match, int price) {
        this.match = match;
        this.price = price;
    }

    public static WinnerRank pleaseCheckMatchCount(int match) {
        for (WinnerRank winnerRank : values()) {
            if(winnerRank.getMatch() == match)
                return winnerRank;
        }
        return NONE;
    }

    public int getMatch() {
        return match;
    }

    public int getPrice() {
        return price;
    }
}
