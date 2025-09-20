package model;

public class MoveCarStrategy {

    private static final int MOVE_THRESHOLD = 4;

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
