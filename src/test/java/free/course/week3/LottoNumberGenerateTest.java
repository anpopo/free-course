package free.course.week3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberGenerateTest {

    public static final List<Integer> LOTTO_CONTAIN_NUMBERS = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
            31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45);

    @RepeatedTest(400)
    @DisplayName("번호 1개 랜덤 생성")
    void generateOneRandomNumber() {
        LottoNumber lottoNumber = LottoNumberGenerator.generateOneRandomNumber();
        Assertions.assertThat(lottoNumber.getLottoNumber()).isLessThanOrEqualTo(45);
        Assertions.assertThat(lottoNumber.getLottoNumber()).isGreaterThanOrEqualTo(1);
    }


    @RepeatedTest(400)
    @DisplayName("번호 6개 랜덤 생성")
    void generateSixRandomNumber() {
        List<LottoNumber> lottoNumbers = LottoNumberGenerator.generateSixLottoNumber();
        Assertions.assertThat(lottoNumbers.size()).isEqualTo(6);
        List<Integer> onlyNumbers = lottoNumbers.stream().map(LottoNumber::getLottoNumber).collect(Collectors.toList());
        Assertions.assertThat(onlyNumbers).containsAnyElementsOf(LOTTO_CONTAIN_NUMBERS);
        Assertions.assertThat(onlyNumbers).doesNotHaveDuplicates();
    }









}
