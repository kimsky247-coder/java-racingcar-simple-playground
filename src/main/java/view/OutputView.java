package view;
import model.Car;
import java.util.List;

public class OutputView {
    private static void printName(String carName) {
        System.out.print(carName + " : ");
    }

    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            printName(car.getCarName());
            printPosition(car.getPosition());
            System.out.println();
        }
        System.out.println();
    }

    public static void printRaceStartMessage() {
        System.out.println("\n실행 결과");
    }

    private static void printPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
    }

    public static void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }

}
