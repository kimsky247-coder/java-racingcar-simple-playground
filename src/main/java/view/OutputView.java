package view;

import model.domain.Car;

import java.util.List;

public class OutputView {

    public static void printSingleCarStatus(String name, int position) {
        System.out.print(name + " : ");
        printPosition(position);
        System.out.println();
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printRaceStartMessage() {
        System.out.println("\n실행 결과");
    }

    private static void printPosition(int position) {
        System.out.print("-".repeat(position));
    }

    public static void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }

}
