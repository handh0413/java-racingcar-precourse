package domain;

import camp.nextstep.edu.missionutils.Randoms;
import utils.ValidationUtils;

public class Car {
    private String name;
    private Movement movement;

    public Car(String name) {
        if (!ValidationUtils.validateCarNameLength(name)) {
            throw new IllegalArgumentException("자동차 이름 길이에 문제가 있습니다.");
        }
        this.name = name;
        movement = new Movement(0);
    }

    public void drive() {
        movement.executeForwardOrStop(Randoms.pickNumberInRange(0, 9));
    }

    public int getPosition() {
        return movement.getPosition();
    }
}
