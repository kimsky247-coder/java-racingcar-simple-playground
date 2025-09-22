package model.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("model.domain.Car 클래스 테스트")
@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class CarTest {

    @Test
    void 자동차_생성_시_이름과_초기_위치가_올바르게_설정된다() {
        String name = "car";

        Car car = Car.fromName(name);

        assertEquals(name, car.getCarName());
        assertEquals(0, car.getPosition());
    }

    @Test
    void moveForward_호출_시_위치가_1_증가한다() {
        Car car = Car.fromName("car");

        car.moveForward();

        assertEquals(1, car.getPosition());
    }

    @Test
    void 자동차_이름이_5자를_초과하면_예외가_발생한다() {
        String carName = "testCar";

        assertThrows(IllegalArgumentException.class, () -> Car.fromName(carName));
    }
}
