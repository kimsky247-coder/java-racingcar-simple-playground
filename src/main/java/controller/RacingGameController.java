package controller;

import model.domain.Car;
import model.domain.Cars;
import model.strategy.MoveCarStrategy;
import model.strategy.NumberGenerator;
import model.domain.Race;
import view.InputView;
import view.OutputView;

import java.util.List;

public class RacingGameController {

    private final NumberGenerator numberGenerator;

    public RacingGameController(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        Cars cars = setupCars();
        Race race = new Race(cars, new MoveCarStrategy(numberGenerator));

        int rounds = InputView.readRounds();
        runRace(race, rounds);
        OutputView.printWinners(race.getWinners());

        InputView.close();
    }

    private Cars setupCars() {
        String[] carNames = InputView.readCarNames();
        return Cars.fromNames(List.of(carNames));
    }

    private void runRace(Race race, int rounds) {
        OutputView.printRaceStartMessage();
        for (int i = 0; i < rounds; i++) {
            race.runRound();
            printCurrentPositions(race.getCars());        }
    }

    private void printCurrentPositions(List<Car> cars) {
        for (Car car : cars) {
            OutputView.printSingleCarStatus(car.getCarName(), car.getPosition());
        }
        OutputView.printNewLine();
    }

}
