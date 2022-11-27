package WorkingWithAbstractionLab1;

import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String rhombOfStars = buildRhombOfStars(n);
        printOutput(rhombOfStars);
    }

    private static String buildRhombOfStars(int size) {
        return printMultipleRows(1, size, 1, size) +
                printMultipleRows(size - 1, 1, -1, size);
    }

    private static String printMultipleRows(int start, int end, int step, int size){
        StringBuilder sb = new StringBuilder();
        Predicate<Integer> loopCondition = iter -> {
            if(step > 0){
                return iter <= end;
            }
            return iter >= end;
        };

        for (int i = start; loopCondition.test(i) ; i += step) {
            sb.append(printLine(size - i, i))
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }

    private static String printLine(int space, int star) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < space; i++) {
            sb.append(" ");
        }
        for (int i = 0; i < star; i++) {
            sb.append("* ");
        }

        return sb.toString();
    }

    private static void printOutput(String rhombOfStars) {
        System.out.println(rhombOfStars);
    }
}
