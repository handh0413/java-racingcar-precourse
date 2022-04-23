package controller;

import domain.Car;
import domain.RacingCars;
import domain.RacingCount;

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

    public Car findRacingCar(String name) {
        return racingCars.find(name);
    }

    public RacingCars getRacingCars() {
        return racingCars;
    }
}
