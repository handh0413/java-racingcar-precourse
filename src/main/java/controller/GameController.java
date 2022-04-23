package controller;

import domain.Car;
import domain.RacingCars;
import domain.RacingCount;
import view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

import static view.InputView.*;

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
            String names = readUserInput(REQUEST_NAMES);
            this.racingCars = new RacingCars(RacingCars.makeCarListFromNames(names));
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            readUserInputForRacingCarNames();
        }
    }

    public void readUserInputForRacingCount() {
        try {
            int count = Integer.parseInt(readUserInput(REQUEST_COUNT));
            this.racingCount = new RacingCount(count);
        } catch (NumberFormatException e) {
            OutputView.printErrorMessage("숫자를 입력해주세요.");
            readUserInputForRacingCount();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
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
