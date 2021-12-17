package free.course.week3.lotto;

import java.util.Objects;

public abstract class Number {
    private Integer number;

    abstract Number generateNumber();

    Number() {}

    public Integer getNumber() {
        return this.number;
    }

    void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return Objects.equals(number, number1.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
