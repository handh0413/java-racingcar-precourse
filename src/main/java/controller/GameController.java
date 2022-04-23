package controller;

import domain.Car;
import domain.RacingCars;
import domain.RacingCount;
import view.InputView;

import java.util.List;
import java.util.stream.Collectors;

public class GameController {
    private RacingCars racingCars;
    private RacingCount racingCount;

    public GameController() { }

    public GameController(RacingCars racingCars, RacingCount racingCount) {
        this.racingCars = racingCars;
        this.racingCount = racingCount;
    }

    public void play() {
        readUserInputForRacingCarNames();
        readUserInputForRacingCount();
    }

    public void readUserInputForRacingCarNames() {
        try {
            String names = InputView.readUserInput(InputView.REQUEST_NAMES);
            this.racingCars = new RacingCars(RacingCars.makeCarListFromNames(names));
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            readUserInputForRacingCarNames();
        }
    }

    public void readUserInputForRacingCount() {
        try {
            int count = Integer.parseInt(InputView.readUserInput(InputView.REQUEST_COUNT));
            this.racingCount = new RacingCount(count);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자를 입력해주세요.");
            readUserInputForRacingCount();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            readUserInputForRacingCount();
        }
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

    public RacingCount getRacingCount() {
        return racingCount;
    }
}
