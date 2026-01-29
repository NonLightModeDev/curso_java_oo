package entities;

import java.text.DecimalFormat;

public class ImportedProduct extends Product {
    private double customsFee;

    public ImportedProduct() {
        super();
    }

    public ImportedProduct(String name, double price, double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    @Override
    public String priceTag() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName());
        sb.append(" $ " + formatDouble(totalPrice()));
        sb.append(" (Customs fee: $" + formatDouble(customsFee) + ")");

        return sb.toString();
    }

    public double totalPrice() {
        return getPrice() + customsFee;
    }
}
