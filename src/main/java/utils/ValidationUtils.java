package utils;

public class ValidationUtils {
    public static final int MOVEMENT_CONDITION_MIN = 0;
    public static final int MOVEMENT_CONDITION_MAX = 9;

    public static final int MOVEMENT_STOP_CONDITION_MIN = 0;
    public static final int MOVEMENT_STOP_CONDITION_MAX = 3;

    public static boolean validateMovementCondition(int number) {
        return MOVEMENT_CONDITION_MIN <= number
                && number <= MOVEMENT_CONDITION_MAX;
    }

    public static boolean validateStopCondition(int condition) {
        return MOVEMENT_STOP_CONDITION_MIN <= condition
                && condition <= MOVEMENT_STOP_CONDITION_MAX;
    }

}
