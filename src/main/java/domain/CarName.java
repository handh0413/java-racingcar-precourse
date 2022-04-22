package domain;

import utils.ValidationUtils;

public class CarName {
    String name;

    public CarName(String name) {
        if (!ValidationUtils.validateCarNameLength(name)) {
            throw new IllegalArgumentException("자동차 이름 길이에 문제가 있습니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
