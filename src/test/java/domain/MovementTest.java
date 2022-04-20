package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MovementTest {

    @Test
    @DisplayName("FORWARD_STOP_범위_조건_확인")
    public void FORWARD_STOP_범위_조건_확인() {
        Movement movement = new Movement();
        assertThat(movement.isMovable(0)).isEqualTo(MovementStatus.STOP);
        assertThat(movement.isMovable(3)).isEqualTo(MovementStatus.STOP);
        assertThat(movement.isMovable(4)).isEqualTo(MovementStatus.FORWARD);
        assertThat(movement.isMovable(9)).isEqualTo(MovementStatus.FORWARD);

        assertThrows(IllegalArgumentException.class, () -> {
            movement.isMovable(-1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            movement.isMovable(10);
        });
    }

}
