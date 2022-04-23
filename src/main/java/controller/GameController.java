package controller;

import domain.Car;
import domain.RacingCars;
import domain.RacingCount;

import java.util.List;
import java.util.stream.Collectors;

public class GameController {
    private RacingCars racingCars;
    private RacingCount racingCount;

    public GameController(RacingCars racingCars, RacingCount racingCount) {
        this.racingCars = racingCars;
        this.racingCount = racingCount;
    }

    public void startRacing() {
        for (int i = 0; i < racingCount.getCount(); i++) {
            racingCars.drive();
        }
    }

    public List<Car> findWinners() {
        int highest = findWinnersPosition();
        return getRacingCars().getCars().stream()
                .filter(car -> car.getPosition() == highest)
                .collect(Collectors.toList());
    }

    public int findWinnersPosition() {
        return getRacingCars().getCars().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(-1);
    }

    public Car findRacingCar(String name) {
        return racingCars.find(name);
    }

    public RacingCars getRacingCars() {
        return racingCars;
    }
}
