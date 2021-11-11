package free.course.week2;

public class Car {

    private String carName;

    public String getCarName() {
        return this.carName;
    }

    public void validCarNameAndSetName(String carName) {
        if(CarUtils.carNameValid(carName)) {
            this.carName = carName;
        }

    }
}
