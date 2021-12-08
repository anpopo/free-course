package free.course.week3;

public class WinnerChecker {
    public static WinnerChecker createWinnerChecker() {
        return new WinnerChecker();
    }

    public WinnerRank check(int match) {
        return WinnerRank.pleaseCheckMatchCount(match);
    }
}
