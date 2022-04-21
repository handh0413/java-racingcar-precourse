package domain;

import utils.ValidationUtils;

public class Movement {

    public MovementStatus getMovementStatus(int number) {
        if (!ValidationUtils.validateMovementCondition(number)) {
            throw new IllegalArgumentException("처리 불가능한 입력 값입니다.");
        }
        if (ValidationUtils.validateStopCondition(number)) {
            return MovementStatus.STOP;
        }
        return MovementStatus.FORWARD;
    }

}