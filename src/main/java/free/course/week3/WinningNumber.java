package free.course.week3;

public class WinningNumber extends LottoBall {
    private final int number;

    protected WinningNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public int hashCode() {
        return this.number;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof WinningNumber) return this.number == ((WinningNumber) obj).getNumber();
        return false;
    }
}
