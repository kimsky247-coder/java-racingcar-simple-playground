import model.Car;
import model.MoveCar;
import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoveCarTest {

    @Test
    void 랜덤_값이_4_이상이면_자동차가_전진한다() {
        Random predictableRandom = new PredictableRandom(4);
        MoveCar moveCar = new MoveCar(predictableRandom);
        Car car = new Car("car");

        moveCar.tryMove(car);

        assertEquals(1, car.getPosition());
    }

    @Test
    void 랜덤_값이_3_이하이면_자동차가_전진하지_않는다() {
        Random predictableRandom = new PredictableRandom(3);
        MoveCar moveCar = new MoveCar(predictableRandom);
        Car car = new Car("car");

        moveCar.tryMove(car);

        assertEquals(0, car.getPosition());
    }

}
