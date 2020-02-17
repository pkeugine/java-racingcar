package racingcargame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @Test
    void 자동차는_이름을_입력받아_생성() {
        String name = "라테";
        Car car = new Car(name);
        assertThat(car)
                .extracting("name")
                .hasFieldOrPropertyWithValue("name", "라테");
    }

    @Test
    void null방어로직_확인() {
        Name name = null;
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car(name));
    }

    @Test
    void 자동차_이름은_5자이내여야_한다() {
        String name = "notfive!!";
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차는_4이상의숫자를받으면_전진한다() {
        String name = "장재주";
        Car car = new Car(name);
        car.move(4);
        assertThat(car).extracting("position").hasFieldOrPropertyWithValue("position", 1);
    }

    @Test
    void 자동차는_3이하일경우_전진하지않는다() {
        String name = "장재주";
        Car car = new Car(name);
        car.move(3);
        assertThat(car).extracting("position").hasFieldOrPropertyWithValue("position", 0);
    }
}