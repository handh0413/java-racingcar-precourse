package domain;

import java.util.Collections;
import java.util.List;

public class RacingCars {
    private List<Car> cars;

    public RacingCars(List<Car> cars) {
        if (!ValidationUtils.validateRacingCarsSize(cars)) {
            throw new IllegalArgumentException("자동차 개수 사이즈에 문제가 있습니다.");
        }
        this.cars = cars;
    }

    public int getSize() {
        return cars.size();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
