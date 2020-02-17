package racingcargame.view.input;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static String askCarNames() {
        System.out.println("자동차 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public static int askTotalRounds() {
        System.out.println("시도 횟수를 입력하세요.");
        String string = scanner.nextLine();
        validateNumeric(string);
        return Integer.parseInt(string);
    }

    private static void validateNumeric(String string) {
        for (int i = 0; i < string.length(); i++) {
            validateNumericChar(string.charAt(i));
        }
    }

    private static void validateNumericChar(char character) {
        if (character < '0' || character > '9') {
            throw new IllegalArgumentException("숫자만 입력하세요");
        }
    }
}