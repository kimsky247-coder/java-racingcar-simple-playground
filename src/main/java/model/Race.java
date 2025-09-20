package model;

import java.util.List;

public class Race {

    private Cars cars;
    private MoveCarStrategy moveCarStrategy;

    public Race(Cars cars, MoveCarStrategy moveCarStrategy) {
        this.cars = cars;
        this.moveCarStrategy = moveCarStrategy;
    }

    public void runRound() {
        cars.moveEachCar(moveCarStrategy);
    }

    public List<String> getWinners() {
        return cars.findWinners();
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

}
