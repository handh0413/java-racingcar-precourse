package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingCars {
    private List<Car> cars;

    public RacingCars(List<Car> cars) {
        if (!ValidationUtils.validateRacingCarsSize(cars)) {
            throw new IllegalArgumentException("자동차 개수 사이즈에 문제가 있습니다.");
        }
        this.cars = cars;
    }

    static List<Car> makeCarListFromNames(String names) {
        List<Car> carList = Stream.of(names.split(","))
                .map(String::trim)
                .map(Car::new)
                .distinct()
                .collect(Collectors.toList());
        return carList;
    }

    public int getSize() {
        return cars.size();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
