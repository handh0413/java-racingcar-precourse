package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ValidationUtilsTest {

    @Test
    @DisplayName("랜덤_숫자_범위_0_9")
    public void 랜덤_숫자_범위_0_9() {
        assertThat(ValidationUtils.validateNumber(10)).isEqualTo(false);
        assertThat(ValidationUtils.validateNumber(9)).isEqualTo(true);
        assertThat(ValidationUtils.validateNumber(0)).isEqualTo(true);
        assertThat(ValidationUtils.validateNumber(-1)).isEqualTo(false);
    }
}