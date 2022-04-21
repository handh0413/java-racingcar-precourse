package domain;

import utils.ValidationUtils;

public class Car {
    private String name;

    public Car(String name) {
        if (!ValidationUtils.validateCarNameLength(name)) {
            throw new IllegalArgumentException("자동차 이름 길이에 문제가 있습니다.");
        }
        this.name = name;
    }
}
