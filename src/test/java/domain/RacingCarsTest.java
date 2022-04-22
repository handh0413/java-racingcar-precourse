package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

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
    @CsvSource({"1", "2", "3", "4", "5", "6"})
    @DisplayName("경주용_자동차_리스트_생성_사이즈_검증")
    public void 경주용_자동차_리스트_생성_사이즈_검증(int size) {
        for (int i = 0; i < size; i++) {
            cars.add(new Car("test" + i));
        }
        assertDoesNotThrow(() -> {
            new RacingCars(cars);
        });
    }

    @Test
    @DisplayName("경주용_자동차_리스트_생성_사이즈_검증_예외")
    public void 경주용_자동차_리스트_생성_사이즈_검증_예외() {
        Throwable exceptionThrown = assertThrows(IllegalArgumentException.class, () -> {
            new RacingCars(cars);
        });
        assertThat(exceptionThrown.getMessage()).isEqualTo("자동차 개수 사이즈에 문제가 있습니다.");
    }

    @ParameterizedTest
    @CsvSource({"1,1", "2,2", "3,3", "4,4", "5,5", "6,6"})
    public void 경주용_자동차_사이즈_검증(int size, int expectedSize) {
        for (int i = 0; i < size; i++) {
            cars.add(new Car("test" + i));
        }
        RacingCars racingCars = new RacingCars(cars);
        assertThat(racingCars.getSize()).isEqualTo(expectedSize);
    }

    @Test
    public void 경주용_자동차_리스트_추가_불가_검증() {
        cars.add(new Car("car1"));
        assertThrows(UnsupportedOperationException.class, () -> {
            RacingCars rcList = new RacingCars(cars);
            List<Car> returnedList = rcList.getCars();
            returnedList.add(new Car("car2"));
        });
    }
}