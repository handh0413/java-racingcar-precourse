package domain;

import java.util.List;

public class RacingCars {
    private List<Car> cars;

    public RacingCars(List<Car> cars) {
        if (!ValidationUtils.validateRacingCarsSize(cars)) {
            throw new IllegalArgumentException("자동차 개수 사이즈에 문제가 있습니다.");
        }
        this.cars = cars;
    }
}
