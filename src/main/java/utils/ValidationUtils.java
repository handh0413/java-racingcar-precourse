package utils;

public class ValidationUtils {

    public static boolean validateMovementCondition(int number) {
        return 0 <= number && number <= 9;
    }
}
