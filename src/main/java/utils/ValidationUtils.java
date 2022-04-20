package utils;

import domain.Constant;

public class ValidationUtils {

    public static boolean validateMovementCondition(int number) {
        return Constant.MOVEMENT_STOP_CONDITION_MIN <= number
                && number <= Constant.MOVEMENT_STOP_CONDITION_MAX;
    }
}
