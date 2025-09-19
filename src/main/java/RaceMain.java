import controller.RacingGameController;
import model.NumberGenerator;
import model.RandomNumberGenerator;

public class RaceMain {
    public static void main(String[] args) {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        RacingGameController controller = new RacingGameController(numberGenerator);
        controller.run();
    }
}
