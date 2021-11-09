package free.course.week1.baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationUtilsTest {
    @Test
    @DisplayName("유효하지 않은 숫자 검증 1, 9 숫자 검증")
    void validateNumber() {
        Assertions.assertThat(ValidationUtils.validNumber(9)).isTrue();
        Assertions.assertThat(ValidationUtils.validNumber(1)).isTrue();
        Assertions.assertThat(ValidationUtils.validNumber(0)).isFalse();
        Assertions.assertThat(ValidationUtils.validNumber(10)).isFalse();
    }
}
