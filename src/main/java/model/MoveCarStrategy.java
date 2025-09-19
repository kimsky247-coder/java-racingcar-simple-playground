package model;

public class MoveCarStrategy {
    private static final int MOVE_THRESHOLD = 4;
    private static final int RANDOM_NUMBER_BOUND = 10;
    private final NumberGenerator numberGenerator;

    public MoveCarStrategy(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void tryMove(Car car) {
        int randomNumber = numberGenerator.generate();

        if (shouldMove(randomNumber)) {
            car.moveForward();
        }
    }

    private boolean shouldMove(int randomNumber) {
        return randomNumber >= MOVE_THRESHOLD;
    }

}
