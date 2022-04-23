package controller;

import camp.nextstep.edu.missionutils.Randoms;
import domain.RacingCars;
import domain.RacingCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

class GameControllerTest {

    @Test
    @DisplayName("주행_테스트")
    public void 주행_테스트() {
        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(4, 0, 5, 1, 6, 2, 7, 3);
            RacingCars racingCars = new RacingCars(RacingCars.makeCarListFromNames("tom,jack"));
            GameController controller = new GameController(racingCars, new RacingCount(4));
            controller.startRacing();

            assertThat(controller.findRacingCar("tom").getPosition()).isEqualTo(4);
            assertThat(controller.findRacingCar("jack").getPosition()).isEqualTo(0);
        }
    }

}
