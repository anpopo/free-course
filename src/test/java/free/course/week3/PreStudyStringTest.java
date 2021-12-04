package free.course.week3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PreStudyStringTest {

    @Test
    @DisplayName("문자열 '1,2' 를 , 로 split 했을때 1과 2로 분리되는지 확인")
    void splitTest() {
        // given
        String numberWithComma = "1,2";

        // when
        String[] split = numberWithComma.split(",");

        // then
        assertThat(split.length).isEqualTo(2);
        assertThat(split).containsExactly("1", "2");
    }

    @Test
    @DisplayName("문자열 '1' 을 , 로 split 했을때 1 분리되는지 확인")
    void splitTestWithSingle() {
        // given
        String numberWithComma = "1";

        // when
        String[] split = numberWithComma.split(",");

        // then
        assertThat(split.length).isEqualTo(1);
        assertThat(split).containsExactly("1");
    }

    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String 의 substring() 메소드를 활용해()을 제거")
    void splitTestWithSubstring() {
        // given
        String numberWithComma = "(1,2)";

        // when
        String[] split = numberWithComma.substring(0, numberWithComma.length() - 1).substring(1).split(",");

        // then
        assertThat(split.length).isEqualTo(2);
        assertThat(split).containsExactly("1", "2");
    }

    @Test
    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져온다")
    void charAtExceptionTest() {
        // given
        String numberWithComma = "abc";

        // then
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> numberWithComma.charAt(3))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .withMessageContaining("range: 3");
    }
}
