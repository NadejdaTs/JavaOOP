package WorkingWithAbstractionLab4;

import java.util.Arrays;
import java.util.Scanner;

public class Reader {
    public static Scanner sc = new Scanner(System.in);

    public static int[] readArray(String delimiter){
        return Arrays.stream(sc.nextLine().split(delimiter))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static String[] readStringArray(String delimiter){
        return sc.nextLine().split(delimiter);
    }
}
