package EncapsulationEx2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        int age = sc.nextInt();

        try{
            Chicken chicken = new Chicken(name, age);
            System.out.println(chicken);
        }catch(IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
}
