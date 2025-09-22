package model.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("model.domain.Race 클래스 테스트")
@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class RaceTest {

    @Test
    void 우승자가_한_명인_경우_우승자_한_명만_반환한다() {
        Car car1 = Car.fromName("car1");
        Car car2 = Car.fromName("car2");
        Car car3 = Car.fromName("car3");
        Cars cars = new Cars(List.of(car1, car2, car3));
        Race race = new Race(cars, null);

        moveCarNTimes(car1, 1);
        moveCarNTimes(car2, 2);
        moveCarNTimes(car3, 3);

        List<String> winners = race.getWinners();

        assertEquals(1, winners.size());
        assertEquals("car3", winners.get(0));
    }

    @Test
    void 우승자가_두_명_이상인_경우_모든_우승자를_반환한다() {
        Car car1 = Car.fromName("car1");
        Car car2 = Car.fromName("car2");
        Car car3 = Car.fromName("car3");
        Cars cars = new Cars(List.of(car1, car2, car3));
        Race race = new Race(cars, null);

        moveCarNTimes(car1, 1);
        moveCarNTimes(car2, 2);
        moveCarNTimes(car3, 2);

        List<String> winners = race.getWinners();

        assertEquals(2, winners.size());
        assertTrue(winners.containsAll(List.of("car2", "car3")));
    }

    private void moveCarNTimes(Car car, int times) {
        for (int i = 0; i < times; i++) {
            car.moveForward();
        }
    }

}
