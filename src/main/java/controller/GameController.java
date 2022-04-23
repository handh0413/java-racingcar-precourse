package controller;

import domain.Car;
import domain.RacingCars;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameController {
    private RacingCars racingCars;

    static RacingCars makeRacingCarsFromNames(String names) {
        List<Car> carList = Stream.of(names.split(","))
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
        return new RacingCars(carList);
    }

    public void setRacingCars(String names) {
        this.racingCars = makeRacingCarsFromNames(names);
    }
}
