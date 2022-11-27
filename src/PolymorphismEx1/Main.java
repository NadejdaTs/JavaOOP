package PolymorphismEx1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] tokens = sc.nextLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));

        tokens = sc.nextLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));

        int n = Integer.parseInt(sc.nextLine());
        while(n-- > 0){
            String command = sc.nextLine();
            String[] params = command.split("\\s+");

            double argument = Double.parseDouble(params[2]);

            if(command.contains("Drive")){
                if(params[1].contains("Car")){
                    System.out.println(car.drive(argument));
                }else{
                    System.out.println(truck.drive(argument));
                }
            }else{
                if(params[1].contains("Car")){
                    car.refuel(argument);
                }else{
                    truck.refuel(argument);
                }
            }
        }
        System.out.println(car);
        System.out.println(truck);
    }
}
