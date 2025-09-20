package model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars fromNames(List<String> carNames) {
        List<Car> carList = carNames.stream()
                .map(Car::fromName)
                .collect(Collectors.toList());
        return new Cars(carList);
    }

    public void moveEachCar(MoveCarStrategy moveCarStrategy) {
        for (Car car : cars) {
            moveCarStrategy.tryMove(car);
        }
    }

    public List<String> findWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

}
