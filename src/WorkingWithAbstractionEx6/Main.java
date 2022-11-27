package WorkingWithAbstractionEx6;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long input = Long.parseLong(scanner.nextLine());
        String[] safe = scanner.nextLine().split("\\s+");

        var bag = new LinkedHashMap<String, LinkedHashMap<String, Long>>();
        long gold = 0;
        long stones = 0;
        long money = 0;

        for (int i = 0; i < safe.length; i += 2) {
            String name = safe[i];
            long count = Long.parseLong(safe[i + 1]);

            String item = "";
            String nameOfItem = name.toLowerCase();
            if (name.length() == 3) {
                item = "Cash";
            } else if (nameOfItem.endsWith("gem")) {
                item = "Gem";
            } else if (nameOfItem.equals("gold")) {
                item = "Gold";
            }

            if (item.equals("")) {
                continue;
            } else if (input < bag.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + count) {
                continue;
            }

            switch (item) {
                case "Gem":
                    if (add(bag, count, item, "Gold")) continue;
                    break;
                case "Cash":
                    if (add(bag, count, item, "Gem")) continue;
                    break;
            }

            if (!bag.containsKey(item)) {
                bag.put((item), new LinkedHashMap<String, Long>());
            }

            if (!bag.get(item).containsKey(name)) {
                bag.get(item).put(name, 0L);
            }


            bag.get(item).put(name, bag.get(item).get(name) + count);
            if (item.equals("Gold")) {
                gold += count;
            } else if (item.equals("Gem")) {
                stones += count;
            } else if (item.equals("Cash")) {
                money += count;
            }
        }

        for (var x : bag.entrySet()) {
            Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.println(String.format("<%s> $%s", x.getKey(), sumValues));

            x.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }

    private static boolean add(LinkedHashMap<String, LinkedHashMap<String, Long>> bag, long count, String item, String gem) {
        if (!bag.containsKey(item)) {
            if (bag.containsKey(gem)) {
                if (count > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                    return true;
                }
            } else {
                return true;
            }
        } else if (bag.get(item).values().stream().mapToLong(e -> e).sum() + count > bag.get(gem).values().stream().mapToLong(e -> e).sum()) {
            return true;
        }
        return false;
    }
}
