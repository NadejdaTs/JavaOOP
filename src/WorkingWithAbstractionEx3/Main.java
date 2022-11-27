package WorkingWithAbstractionEx3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*System.out.println("Card Ranks:");
        for (CardRank rank : CardRank.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", rank.ordinal(), rank.toString());
        }*/

        String rank = sc.nextLine();
        String suit = sc.nextLine();
        int power = CardRank.valueOf(rank).getRankPower() + CardSuit.valueOf(suit).getSuitPower();
        System.out.printf("Card name: %s of %s; Card power: %d", rank, suit, power);
    }
}
