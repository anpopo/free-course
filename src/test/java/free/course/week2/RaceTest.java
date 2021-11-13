package free.course.week2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RaceTest {


    public static final int TRY_NUMBER = 5;
    private GameJoinedCars cars;

    @BeforeEach
    public void setUp () {
        cars = CarsFactory.createGameJoinedCars(List.of("카이로", "서울", "부에노스아이레스", "타이페이", "도쿄"));
    }

    @Test
    void 입력받은_자동차_대수와_수행_횟수를_가진_경기를_생성한다() {

        // when
        Race race = Race.createRaceWithTryNumberAndCars(TRY_NUMBER, cars);

        // then
        Assertions.assertThat(race.getTryNumber()).isEqualTo(TRY_NUMBER);

        Assertions.assertThat(race.getCars().getJoinedCarsCount()).isEqualTo(cars.getJoinedCarsCount());
    }

    @Test
    void 입력받은_자동차_수행횟수_만큼_경기를_수행한다 (){
        // when
        Race race = Race.createRaceWithTryNumberAndCars(TRY_NUMBER, cars);

        // then
        Assertions.assertThat(race.getTryNumber()).isEqualTo(TRY_NUMBER);
    }

    @Test
    void 경기_횟수만큼_경기_실행_후_우승자를_반환한다() {
        //given
        Race race = Race.createRaceWithTryNumberAndCars(TRY_NUMBER, cars);

        // when
        Winners winners = race.doRaceAndGetWinners();

        // then
        Assertions.assertThat(winners.getWinners()).isNotEmpty();
        Assertions.assertThat(winners.getWinnersCount()).isGreaterThan(0);
    }

    @Test
    void 경기_종료_후_우승자_명단() {
        //given
        Race race = Race.createRaceWithTryNumberAndCars(TRY_NUMBER, cars);

        // when
        Winners winners = race.doRaceAndGetWinners();

        // given

        System.out.println(winners.getWinnersName());
    }
}
