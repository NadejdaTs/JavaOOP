package WorkingWithAbstractionLab4;

public class Main {
    public static void main(String[] args) {
        String[] tokens = Reader.readStringArray("\\s+");

        double pricePerDay = Double.parseDouble(tokens[0]);
        int days = Integer.parseInt(tokens[1]);
        Season season = Season.valueOf(tokens[2].toUpperCase());
        Discount discount = Discount.parceDiscount(tokens[3]);

        PriceCalculator calculator = new PriceCalculator(pricePerDay, days, season, discount);

        System.out.printf("%.2f%n", calculator.calculatePrice());
    }
}
