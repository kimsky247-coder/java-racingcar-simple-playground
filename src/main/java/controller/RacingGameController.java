package controller;

import model.*;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
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
        OutputView.printRaceStartMessage();
        runRace(race, rounds);
        OutputView.printWinners(race.getWinners());

        InputView.close();
    }

    private Cars setupCars() {
        String[] carNames = InputView.readCarNames();
        List<Car> carList = new ArrayList<>();
        for (String name : carNames) {
            carList.add(Car.fromName(name));
        }
        return new Cars(carList);
    }

    private void runRace(Race race, int rounds) {
        for (int i = 0; i < rounds; i++) {
            race.runRound();
            OutputView.printRoundResult(race.getCars());
        }
    }

}
