package free.course.week2;

public class Race {
    private static final int MAX_TRY = 10;

    private int tryNumber;
    private GameJoinedCars cars;
    private Winners winners;

    public static Race createRaceWithTryNumberAndCars(int tryNumber, GameJoinedCars cars) {

        Race newRace = new Race();
        newRace.tryNumber = Math.min(tryNumber, MAX_TRY);
        newRace.cars = cars;

        return newRace;
    }

    public int getTryNumber() {
        return tryNumber;
    }

    public GameJoinedCars getCars() {
        return cars;
    }

    public void racing() {

        for(int i = 0; i < this.tryNumber; i++) {
            cars.getJoinedCars().forEach(Car::stopOrGo);
            System.out.println();
        }

        this.winners = new Winners(this.cars.getWinnerList());
    }

    public int getWinnerCount() {
        return this.winners.getWinnersCount();
    }

    public Winners doRaceAndGetWinners() {
        this.racing();

        return this.winners;
    }
}
