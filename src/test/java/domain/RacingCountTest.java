package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingCountTest {

    @ParameterizedTest
    @CsvSource(value = {"1, 5, 10, 15, 30"})
    @DisplayName("시도_횟수_입력_테스트")
    public void 시도_횟수_입력_테스트(int count) {
        assertDoesNotThrow(() -> {
            new RacingCount(count);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"-10, -5, -1, 0"})
    @DisplayName("시도_횟수_입력_예외_테스트")
    public void 시도_횟수_입력_예외_테스트(int count) {
        Throwable exceptionThrown = assertThrows(IllegalArgumentException.class, () -> {
            new RacingCount(count);
        });
        assertThat(exceptionThrown.getMessage()).isEqualTo("시도 횟수는 자연수 범위의 값을 입력해주세요.");
    }
}