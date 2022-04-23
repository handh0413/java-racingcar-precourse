package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RacingCarsTest {

    @ParameterizedTest
    @CsvSource({"'pobi'", "'pobi,woni'", "'pobi,woni,jun'", "'pobi,woni,jun,toby'", "'pobi,woni,jun,toby,jack'"})
    @DisplayName("경주용_자동차_리스트_요소_사이즈_테스트")
    public void 경주용_자동차_리스트_요소_사이즈_테스트(String names) {
        assertDoesNotThrow(() -> {
            new RacingCars(RacingCars.makeCarListFromNames(names));
        });
    }

    @Test
    @DisplayName("경주용_자동차_리스트_요소_이름_길이_테스트")
    public void 경주용_자동차_리스트_요소_이름_길이_테스트() {
        Throwable exceptionThrown = assertThrows(IllegalArgumentException.class, () -> {
            new RacingCars(RacingCars.makeCarListFromNames(""));
        });
        assertThat(exceptionThrown.getMessage()).isEqualTo("자동차 이름 길이에 문제가 있습니다.");
    }

    @ParameterizedTest
    @CsvSource({"'pobi,woni,jun,toby,jack'"})
    @DisplayName("경주용_자동차_리스트_생성_사이즈_검증_예외")
    public void 경주용_자동차_리스트_추가_불가_검증(String names) {
        assertThrows(UnsupportedOperationException.class, () -> {
            RacingCars rcList = new RacingCars(RacingCars.makeCarListFromNames(names));
            List<Car> returnedList = rcList.getCars();
            returnedList.add(new Car("new"));
        });
    }

}