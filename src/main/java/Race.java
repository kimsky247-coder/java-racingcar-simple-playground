import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Car> cars;
    private int rounds;

    public Race() {
        this.cars = new ArrayList<>();
        rounds = 0;
    }

    public void addCar(Car car) {
        this.cars.add(car);
    }

    public void defineRounds(int rounds) {
        this.rounds = rounds;
    }


    public void startRace() {
        for (int i = 0; i < rounds; i++) {
            runRace();
        }
    }

    private void runRace() {
        for (Car car : cars) {
            int randomNumber  = car.generateRandomNumber();
            car.carMove(randomNumber);
        }
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = comparisonPosition(maxPosition, car);
        }
        return maxPosition;
    }

    private int comparisonPosition(int maxPosition, Car car) {
        if (car.getPosition() > maxPosition) {
            maxPosition = car.getPosition();
        }
        return maxPosition;
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
          addWinner(maxPosition, car, winners);
        }
        return winners;
    }

    private void addWinner(int maxPosition, Car car, List<String> winners) {
        if (car.getPosition() == maxPosition) {
            winners.add(car.getCarName());
        }

    }

}
