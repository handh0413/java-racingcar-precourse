package view;

import domain.Car;
import domain.RacingCars;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR]";

    public static void printErrorMessage(Exception exception) {
        System.out.println(ERROR_PREFIX + " " + exception.getMessage());
    }

    public static void printErrorMessage(String message) {
        System.out.println(ERROR_PREFIX + " " + message);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printLine() {
        System.out.println();
    }

    public static void printRacingResult(RacingCars rc) {
        for (Car car : rc.getCars()) {
            printCarResult(car);
        }
        System.out.println();
    }

    private static void printCarResult(Car car) {
        System.out.print(car.getCarName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
