package domain;

import utils.ValidationUtils;

public class Movement {
    private int position;

    public Movement(int position) {
        this.position = position;
    }

    public void executeForwardOrStop(int number) {
        MovementStatus status = getMovementStatus(number);
        if (status.isForward()) {
            forward();
        }
    }

    MovementStatus getMovementStatus(int number) {
        if (!ValidationUtils.validateMovementCondition(number)) {
            throw new IllegalArgumentException("처리 불가능한 입력 값입니다.");
        }
        if (ValidationUtils.validateStopCondition(number)) {
            return MovementStatus.STOP;
        }
        return MovementStatus.FORWARD;
    }

    void forward() {
        position += 1;
    }

    public int getPosition() {
        return position;
    }

}
