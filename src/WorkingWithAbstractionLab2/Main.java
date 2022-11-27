package WorkingWithAbstractionLab2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] rectanglePoints = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Point a = new Point(rectanglePoints[0], rectanglePoints[1]);
        Point b = new Point(rectanglePoints[2], rectanglePoints[3]);

        Rectangle rect = new Rectangle(a, b);

        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");
            Point p = new Point(Integer.parseInt(input[0]), Integer.parseInt(input[1]));

            boolean isWithin = rect.contains(p);
            System.out.println(isWithin);
        }
    }
}
