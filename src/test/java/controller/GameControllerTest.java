package controller;

import domain.RacingCars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameControllerTest {

    @Test
    @DisplayName("자동차_리스트_생성_테스트_리스트_사이즈0_예외")
    public void 자동차_리스트_생성_테스트_리스트_사이즈0_예외() {
        assertThrows(IllegalArgumentException.class, () -> {
            GameController.makeRacingCarsFromNames("");
        });
    }

    @Test
    @DisplayName("자동차_리스트_생성_테스트_이름_길이_5초과_예외")
    public void 자동차_리스트_생성_테스트_이름_길이_5초과_예외() {
        assertThrows(IllegalArgumentException.class, () -> {
            GameController.makeRacingCarsFromNames("pobi,crong,banana");
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"'pobi,crong,honux':3", "'pobi,woni,jun,toby,jack':5"}, delimiter = ':')
    @DisplayName("자동차_리스트_생성_테스트")
    public void 자동차_리스트_생성_테스트(String names, int expected) {
        RacingCars racingCars = GameController.makeRacingCarsFromNames(names);
        assertThat(racingCars.getCars().size()).isEqualTo(expected);
    }
}
