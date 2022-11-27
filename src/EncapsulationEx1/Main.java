package EncapsulationEx1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double length = Double.parseDouble(sc.nextLine());
        double width = Double.parseDouble(sc.nextLine());
        double height = Double.parseDouble(sc.nextLine());

        try{
            Box box = new Box(length, width, height);
            System.out.printf("Surface Area - %.2f%nLateral Surface Area - %.2f%nVolume – %.2f%n", box.calculateSurfaceArea(), box.calculateLateralSurfaceArea(), box.calculateVolume());
        }catch(IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
}
