package free.course.week3;

import java.util.Random;

public class LottoNumber {

    private final int number;

    public LottoNumber() {
        this.number = getRandomNumberFrom1To45();
    }

    public LottoNumber(int testNumber) {
        this.number = testNumber;
    }

    private int getRandomNumberFrom1To45() {
        Random rand = new Random();
        return rand.nextInt(45) + 1;
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
        if(obj instanceof LottoNumber) return this.number == ((LottoNumber) obj).getNumber();
        return false;
    }
}
