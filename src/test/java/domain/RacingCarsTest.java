package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RacingCarsTest {
    private ArrayList<Car> cars;

    @BeforeEach
    public void beforeEach() {
        cars = new ArrayList<>();
    }

    @ParameterizedTest
    @CsvSource({"1,true", "2,true", "3,true", "4,true", "5,true", "6,true"})
    @DisplayName("경주용_자동차_리스트_생성_검증")
    public void 경주용_자동차_리스트_생성_검증(int size, boolean expected) {
        for (int i = 0; i < size; i++) {
            cars.add(new Car("test" + i));
        }
        assertDoesNotThrow(() -> {
            new RacingCars(cars);
        });
    }

    @Test
    @DisplayName("경주용_자동차_리스트_생성_검증_예외")
    public void 경주용_자동차_리스트_생성_검증_예외() {
        Throwable exceptionThrown = assertThrows(IllegalArgumentException.class, () -> {
            new RacingCars(cars);
        });
        assertThat(exceptionThrown.getMessage()).isEqualTo("자동차 개수 사이즈에 문제가 있습니다.");
    }

}