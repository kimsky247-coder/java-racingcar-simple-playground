import model.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("model.Car 클래스 테스트")
public class CarTest {

    @Test
    void 자동차_생성_시_이름과_초기위치가_올바르게_설정된다() {
        String carName = "car";

        Car car = new Car(carName);

        assertEquals(carName, car.getCarName());
        assertEquals(0, car.getPosition());
    }

    @Test
    void moveForward_호출시_위치가_증가한다() {
        Car car = new Car("car");

        car.moveForward();

        assertEquals(1, car.getPosition());
    }


    @Test
    void 자동차_이름이_5자를_초과하면_예외가_발생한다(){
        String carName = "TestCar";

        assertThrows(IllegalArgumentException.class, () -> new Car(carName));
    }
}
