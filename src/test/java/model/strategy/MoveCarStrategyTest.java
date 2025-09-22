package model.strategy;

import model.domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("model.strategy.MoveCarStrategy 클래스 테스트")
@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class MoveCarStrategyTest {

    @Test
    void 랜덤_값이_4_이상이면_자동차가_전진한다() {
        MoveCarStrategy moveCarStrategy = new MoveCarStrategy(new PredictableNumberGenerator(4));
        Car car = Car.fromName("car");

        moveCarStrategy.tryMove(car);

        assertEquals(1, car.getPosition());
    }

    @Test
    void 랜덤_값이_3_이하이면_자동차는_멈춘다() {
        MoveCarStrategy moveCarStrategy = new MoveCarStrategy(new PredictableNumberGenerator(3));
        Car car = Car.fromName("car");

        moveCarStrategy.tryMove(car);

        assertEquals(0, car.getPosition());
    }

}
