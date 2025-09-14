import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Race 클래스 테스트")
public class RaceTest {

    @Test
    void 우승자가_한_명인_경우() {
        Random random = new Random();
        MoveCar moveCar = new MoveCar(random);
        Race race =  new Race(moveCar);

        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        race.addCar(car1);
        race.addCar(car2);
        race.addCar(car3);

        car1.moveForward();

        car2.moveForward();
        car2.moveForward();

        car3.moveForward();
        car3.moveForward();
        car3.moveForward();

        List<String> winners = race.getWinners();

        assertEquals(1, winners.size());
        assertEquals("car3", winners.get(0));
    }

    @Test
    void 우승자가_두_명_이상인_경우() {
        Random random = new Random();
        MoveCar moveCar = new MoveCar(random);
        Race race =  new Race(moveCar);

        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        race.addCar(car1);
        race.addCar(car2);
        race.addCar(car3);

        car1.moveForward();

        car2.moveForward();
        car2.moveForward();

        car3.moveForward();
        car3.moveForward();

        List<String> winners = race.getWinners();

        assertEquals(2, winners.size());
        assertEquals("car2", winners.get(0));
        assertEquals("car3", winners.get(1));
    }

}
