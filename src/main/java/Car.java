import java.util.Random;

public class Car {
    private String carName;
    private int position;

    public Car(String carName) {
        this.carName = carName;
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return carName;
    }

    public int generateRandomNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt(10);
        return randomNumber;
    }

    public void carMove(int randomNumber) {
        if (randomNumber >= 4) {
            position += 1;
        }
    }

}