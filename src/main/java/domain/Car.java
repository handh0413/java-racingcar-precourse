package domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private CarName carName;
    private Movement movement;

    public Car(String name) {
        carName = new CarName(name);
        movement = new Movement(0);
    }

    public void drive() {
        movement.executeForwardOrStop(Randoms.pickNumberInRange(0, 9));
    }

    public int getPosition() {
        return movement.getPosition();
    }

    public String getCarName() {
        return carName.getName();
    }
}
