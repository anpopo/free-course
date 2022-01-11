package free.course.racing.common;

import free.course.racing.Players;
import free.course.racing.domain.RacingCar;

public class CustomPrinter {
    public void printPlayerInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분, 1~5 자 이름으로 설정해주세요.)");
    }

    public void errorWhileInput() {
        System.out.println("입력이 잘못되었습니다. 다시 입력해주세요.");
    }

    public void printRoundInput() {
        System.out.println("시도할 횟수는 몇회인가요?");
    }

    public void printGoCount(Players players) {

        for (RacingCar car : players.getRacingCars()) {
            System.out.println(car.getRacingCarName() + " : " + "-".repeat(car.getGoCount()));
        }

    }
}
