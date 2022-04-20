package domain;

import utils.ValidationUtils;

public class Movement {

    public MovementStatus isMovable(int number) {
        if (!ValidationUtils.validateMovementCondition(number)) {
            throw new IllegalArgumentException("처리 불가능한 입력 값입니다.");
        }
        if (isStopRange(number)) {
            return MovementStatus.STOP;
        }
        return MovementStatus.FORWARD;
    }

    private boolean isStopRange(int condition) {
        return Constant.MOVEMENT_STOP_CONDITION_MIN <= condition
                && condition <= Constant.MOVEMENT_STOP_CONDITION_MAX;
    }
}
