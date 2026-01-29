package entities;

import java.text.DecimalFormat;

public class Product {
    private String name;
    private double price;

    private static DecimalFormat dF = new DecimalFormat("0.00");

    public Product() {
        super();
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String priceTag() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(" $ " + formatDouble(price));

        return sb.toString();
    }

    public static String formatDouble(double value) {
        return dF.format(value);
    }
}
