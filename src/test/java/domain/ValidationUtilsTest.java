package domain;

import domain.ValidationUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ValidationUtilsTest {

    @ParameterizedTest
    @CsvSource({"10,false", "9,true", "0,true", "-1,false"})
    @DisplayName("랜덤_숫자_범위_0_9")
    public void 랜덤_숫자_범위_0_9(int conditionNumber, boolean result) {
        assertThat(ValidationUtils.validateMovementCondition(conditionNumber)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource({"4,false", "3,true", "0,true", "-1,false"})
    @DisplayName("정지_조건_범위_0_3")
    public void 정지_조건_범위_0_3(int conditionNumber, boolean result) {
        assertThat(ValidationUtils.validateStopCondition(conditionNumber)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource({"altogether,false", "banana,false", "jason,true", "toby,true", "a,true", ",false"})
    @DisplayName("자동차_이름_길이_검증_1_5")
    public void 자동차_이름_길이_검증_1_5(String name, boolean expected) {
        boolean state = ValidationUtils.validateCarNameLength(name);
        assertThat(state).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"0,false", "1,true", "2,true", "3,true", "4,true", "5,true", "6,true"})
    @DisplayName("경주용_자동차_개수_검증")
    public void 경주용_자동차_개수_검증(int size, boolean expected) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            cars.add(new Car("test" + i));
        }
        boolean state = ValidationUtils.validateRacingCarsSize(cars);
        assertThat(state).isEqualTo(expected);
    }

}
