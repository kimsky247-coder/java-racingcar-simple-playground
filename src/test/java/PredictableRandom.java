import java.util.Random;

public class PredictableRandom extends Random {
    private final int fixedNumber;

    public PredictableRandom(int fixedNumber) {
        this.fixedNumber = fixedNumber;
    }

    @Override
    public int nextInt(int bound) {
        return fixedNumber;
    }
}
