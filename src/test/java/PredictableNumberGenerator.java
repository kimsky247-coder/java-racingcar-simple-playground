import model.NumberGenerator;

public class PredictableNumberGenerator implements NumberGenerator {
    private final int fixedNumber;

    public PredictableNumberGenerator(int fixedNumber) {
        this.fixedNumber = fixedNumber;
    }

    @Override
    public int generate() {
        return fixedNumber;
    }
}
