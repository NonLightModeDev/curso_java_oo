package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product {
    private LocalDate manufactureDate;

    private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public UsedProduct() {
        super();
    }

    public UsedProduct(String name, double price, LocalDate manufactureDate) {
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    @Override
    public String priceTag() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName() + " (used)");
        sb.append(" $ " + formatDouble(getPrice()));
        sb.append(" (Manufacture date: " + formatDate(manufactureDate) + ")");

        return sb.toString();
    }

    public static String formatDate(LocalDate localDate) {
        return fmt.format(localDate);
    }
}
