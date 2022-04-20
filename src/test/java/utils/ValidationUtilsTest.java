package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ValidationUtilsTest {

    @Test
    @DisplayName("랜덤_숫자_범위_0_9")
    public void 랜덤_숫자_범위_0_9() {
        assertThat(ValidationUtils.validateMovementCondition(10)).isEqualTo(false);
        assertThat(ValidationUtils.validateMovementCondition(9)).isEqualTo(true);
        assertThat(ValidationUtils.validateMovementCondition(0)).isEqualTo(true);
        assertThat(ValidationUtils.validateMovementCondition(-1)).isEqualTo(false);
    }
}
