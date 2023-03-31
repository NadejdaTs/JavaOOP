package InterfacesAndAbstractionEx3;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        List<Birthable> birthables = new ArrayList<>();
        while(!input.equals("End")){
            String[] tokens = input.split("\\s+");
            switch(tokens[0]){
                case "Citizen":
                    birthables.add(new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]));
                    break;
                case "Robot":
                    new Robot(tokens[1], tokens[2]);
                    break;
                case "Pet":
                    birthables.add(new Pet(tokens[1], tokens[2]));
                    break;
            }

            input = sc.nextLine();
        }

        String year = sc.nextLine();
        boolean hasOutput = false;

        for (Birthable b : birthables) {
            if(b.getBirthDate().endsWith(year)){
                System.out.println(b.getBirthDate());
                hasOutput = true;
            }
        }

        if(!hasOutput){
            System.out.println("<no output>");
        }
    }
}
