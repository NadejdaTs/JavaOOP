package InterfacesAndAbstractionEx3;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /* Ex 1
        Class[] citizenInterfaces = Citizen.class.getInterfaces();
        if(Arrays.asList(citizenInterfaces).contains(Person.class)){
            Method[] method = Person.class.getDeclaredMethods();

            Scanner sc = new Scanner(System.in);
            String name = sc.nextLine();
            int age = Integer.parseInt(sc.nextLine());

            Person person = new Citizen(name,age);

            System.out.println(method.length);
            System.out.println(person.getName());
            System.out.println(person.getAge());
        }*/
        /* Ex 2
        Class[] citizenInterfaces = Citizen.class.getInterfaces();
        if (Arrays.asList(citizenInterfaces).contains(Birthable.class)
                && Arrays.asList(citizenInterfaces).contains(Identifiable.class)) {
            Method[] methods = Birthable.class.getDeclaredMethods();
            methods = Identifiable.class.getDeclaredMethods();
            Scanner sc = new Scanner(System.in);
            String name = sc.nextLine();
            int age = Integer.parseInt(sc.nextLine());
            String id = sc.nextLine();
            String birthDate = sc.nextLine();
            Identifiable identifiable = new Citizen(name,age,id,birthDate);
            Birthable birthable = new Citizen(name,age,id,birthDate);
            System.out.println(methods.length);
            System.out.println(methods[0].getReturnType().getSimpleName());
            System.out.println(methods.length);
            System.out.println(methods[0].getReturnType().getSimpleName());
        }*/
        // Ex 3
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
