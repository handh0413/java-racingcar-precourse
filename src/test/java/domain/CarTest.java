package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;


class CarTest {

    @ParameterizedTest
    @CsvSource({"a,su,tom,toby,david"})
    @DisplayName("자동차_이름_길이_검증")
    public void 자동차_이름_길이_검증(String name) {
        assertDoesNotThrow(() -> {
            new Car(name);
        });
    }

    @ParameterizedTest
    @CsvSource({"potato,nextstep"})
    @DisplayName("자동차_이름_길이_검증_예외")
    public void 자동차_이름_길이_검증_예외(String name) {
        Throwable exceptionThrown = assertThrows(IllegalArgumentException.class, () -> {
            new Car(name);
        });
        assertThat(exceptionThrown.getMessage()).isEqualTo("자동차 이름 길이에 문제가 있습니다.");
    }
}