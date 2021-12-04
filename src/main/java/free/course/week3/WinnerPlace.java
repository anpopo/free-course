package free.course.week3;

import java.util.Arrays;

public enum WinnerPlace {

    FIRST (6, 2_000_000_000),
    SECOND (5, 1_500_000),
    THIRD (4, 50_000),
    FOURTH(3, 5_000),
    NONE(-1, -1);

    private int match;
    private int price;

    WinnerPlace(int match, int price) {
        this.match = match;
        this.price = price;
    }


    public static WinnerPlace getWinnerPlace(int check) {
        return Arrays.stream(values())
                .filter(winnerPlace -> winnerPlace.getMatch() == check)
                .findFirst().orElseGet(() -> WinnerPlace.NONE);
    }

    public int getMatch() {
        return match;
    }

    public int getPrice() {
        return price;
    }
}
