import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RunRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        MoveCar moveCar = new MoveCar(random);
        Race race = new Race(moveCar);

        System.out.println("Car Name: ");
        String[] carNames = scanner.nextLine().split(",");
        for (String name : carNames) {
            race.addCar(new Car(name.trim()));
        }

        System.out.println("Rounds: ");
        int rounds = scanner.nextInt();
        race.defineRounds(rounds);

        race.startRace();

        List<String> winners = race.getWinners();
        System.out.println("Winners : " + String.join(", ", winners));

        scanner.close();

    }
}
