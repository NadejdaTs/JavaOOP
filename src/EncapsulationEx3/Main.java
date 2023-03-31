package EncapsulationEx3;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputPerson = sc.nextLine().split(";");

        ArrayList<Person> persons = new ArrayList<>();
        for (int i = 0; i < inputPerson.length; i++) {
            String[] token = inputPerson[i].split("=");
            Person person = new Person(token[0], Double.parseDouble(token[1]));
            persons.add(person);
        }

        String[] inputProducts = sc.nextLine().split(";");

        ArrayList<Product> products = new ArrayList<>();
        for (int i = 0; i < inputProducts.length; i++) {
            String[] token = inputProducts[i].split("=");
            Product product = new Product(token[0], Double.parseDouble(token[1]));
            products.add(product);
        }

        LinkedHashMap<String, List<String>> personWithProducts = new LinkedHashMap<>();


        String[] input = sc.nextLine().split("\\s+");
        while(!input[0].equals("END")){
            String name = input[0];
            String product = input[1];

            personWithProducts.putIfAbsent(name, new ArrayList<>());
            personWithProducts.get(name).add(product);

            //TO DO
            Person currPerson = null;
            for (Person p : persons) {
                if(name.equals(p.getName())){
                    Person currProduct = null;
                    for (Product prod : products) {
                        if(product.equals(prod.getName())){
                            p.buyProduct(prod);
                        }
                    }
                }
            }
            input = sc.nextLine().split("\\s+");
        }

        //TO DO
        /*personWithProducts.entrySet().stream()
                .forEach((pair) -> {
                    for (var p : pair.getValue()) {
                        System.out.printf("%s bought %s%n", pair.getKey(), p);
                    }
                });*/
    }
}
