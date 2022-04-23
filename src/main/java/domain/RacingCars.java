package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingCars {
    private List<Car> cars;

    public RacingCars(List<Car> cars) {
        if (!validateDuplicateCar(cars)) {
            throw new IllegalStateException("중복된 이름의 자동차가 포함되어 있습니다.");
        }
        this.cars = cars;
    }

    static boolean validateDuplicateCar(List<Car> cars) {
        List<Car> distinctCars = cars.stream().distinct().collect(Collectors.toList());
        return cars.size() == distinctCars.size();
    }

    public void drive() {
        for (Car car : cars) {
            car.drive();
        }
    }

    public static List<Car> makeCarListFromNames(String names) {
        List<Car> carList = Stream.of(names.split(","))
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
        return carList;
    }

    public Car find(String name) {
        return cars.stream()
                .filter(car -> name.equals(car.getCarName()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 자동차입니다."));
    }

    public int getSize() {
        return cars.size();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

}
