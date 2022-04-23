package domain;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
