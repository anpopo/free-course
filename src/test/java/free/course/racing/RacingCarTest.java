package free.course.racing;

import free.course.racing.domain.RacingCar;
import free.course.racing.domain.RacingCarFactory;
import free.course.racing.exception.InvalidNameException;
import free.course.racing.util.RandomNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarTest {
    @Test
    @DisplayName("부릉 부릉~~ 레이싱 카를 생성한다.")
    void createRacingCar() {
        String source = "name";
        Players players= RacingCarFactory.createRacingCars(source);

        Assertions.assertThat(players.getRacingCars()).isNotEmpty();
        Assertions.assertThat(players.getRacingCars().size()).isEqualTo(1);
        Assertions.assertThat(players.getRacingCars().get(0).getRacingCarName()).isEqualTo(source);
    }

    @Test
    @DisplayName("부릉 부릉~~ 레이싱 카를 생성한다.")
    void createRacingCars() {
        String source = "name,is,very,good";
        Players players = RacingCarFactory.createRacingCars(source);

        Assertions.assertThat(players.getRacingCars()).isNotEmpty();
        Assertions.assertThat(players.getRacingCars().size()).isEqualTo(4);
        Assertions.assertThat(players.getRacingCars()).extracting("racingCarName")
                .containsAnyOf(source.split(","));
    }

    @Test
    @DisplayName("부릉 부릉 레이싱카의 이름이 거지같으면 튕겨낸다.")
    void createRacingCarThrow () {
        String source1 = "source";
        String source2 = "";
        String source3 = ",,,,,,,";
        String source4 = "!";
        String source5 = "겨";

        Assertions.assertThatThrownBy(() -> RacingCarFactory.createRacingCars(source1))
                .isInstanceOf(InvalidNameException.class)
                .hasMessageContaining("LONG");

        Assertions.assertThatThrownBy(() -> RacingCarFactory.createRacingCars(source2))
                .isInstanceOf(InvalidNameException.class)
                .hasMessageContaining("SHORT");

        Assertions.assertThatThrownBy(() -> RacingCarFactory.createRacingCars(source3))
                .isInstanceOf(InvalidNameException.class)
                .hasMessageContaining("Entered");

        Assertions.assertThatThrownBy(() -> RacingCarFactory.createRacingCars(source4))
                .isInstanceOf(InvalidNameException.class)
                .hasMessageContaining("Matched");

        Assertions.assertThat(RacingCarFactory.createRacingCars(source5).getRacingCars()).extracting("racingCarName").containsExactly(source5);
    }

    @RepeatedTest(200)
    @DisplayName("한번의 라운드에 1 - 9 까지 숫자를 생산")
    void checkRandomNumber() {
        String source = "name,is,very,good";
        Players players = RacingCarFactory.createRacingCars(source);

        for(int i = 0; i < players.getRacingCars().size(); i ++) {
            Assertions.assertThat(RandomNumberGenerator.getRandomNumber())
                    .isGreaterThanOrEqualTo(0)
                    .isLessThanOrEqualTo(9);
        }
    }

    @Test
    @DisplayName("값에 따라 전진 하거나 멈춘다.")
    void checkGoOrStop () {
        String source = "name,is,very,good";
        Players players = RacingCarFactory.createRacingCars(source);
        players.goOrStop();
        Assertions.assertThat(players.getRacingCars().stream().map(RacingCar::getGoCount).reduce(0, Integer::sum)).isGreaterThan(0);
    }

}
