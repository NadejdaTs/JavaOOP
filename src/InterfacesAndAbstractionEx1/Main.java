package InterfacesAndAbstractionEx1;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
        }
    }
}
