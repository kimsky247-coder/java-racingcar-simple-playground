package controller;

import model.Car;
import model.Cars;
import model.MoveCarStrategy;
import model.NumberGenerator;
import model.Race;
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
        return Cars.fromNames(List.of(carNames));
    }

    private void runRace(Race race, int rounds) {
        for (int i = 0; i < rounds; i++) {
            race.runRound();
            OutputView.printRoundResult(race.getCars());
        }
    }

}
