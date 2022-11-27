package InterfacesAndAbstractionLab5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Identifiable> Identifiables = new ArrayList<>();

        String line = sc.nextLine();
        while(!line.equals("End")){
            String[] tokens = line.split("\\s+");
            Identifiable identifiable;
            if(tokens.length == 2){
                identifiable = new Robot(tokens[0], tokens[1]);
            }else{
                identifiable = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            }

            Identifiables.add(identifiable);

            line = sc.nextLine();
        }
        String fakeIdPostfix = sc.nextLine();

        for (var Identifiable : Identifiables) {
            if(Identifiable.getId().endsWith(fakeIdPostfix)){
                System.out.println(Identifiable.getId());
            }
        }
    }
}
