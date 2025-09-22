import controller.RacingGameController;
import model.strategy.NumberGenerator;
import model.strategy.RandomNumberGenerator;

public class RaceMain {
    public static void main(String[] args) {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        RacingGameController controller = new RacingGameController(numberGenerator);
        controller.run();
    }
}
