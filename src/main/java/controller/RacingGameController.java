package controller;
import model.Car;
import model.MoveCar;
import model.Race;
import view.InputView;
import view.OutputView;
import java.util.Random;

public class RacingGameController {
    public void run() {
        Race race = new Race(new MoveCar(new Random()));

        setupCars(race);
        int rounds = InputView.readRounds();
        OutputView.printRaceStartMessage();
        runRace(race, rounds);
        OutputView.printWinners(race.getWinners());

        InputView.close();
    }

    private void setupCars(Race race) {
        String[] carNames = InputView.readCarNames();
        for (String name : carNames) {
            race.addCar(new Car(name.trim()));
        }
    }

    public void runRace(Race race, int rounds) {
        for (int i = 0; i < rounds; i++) {
            race.runRound();
            OutputView.printRoundResult(race.getCars());
        }
    }

}
