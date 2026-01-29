import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Product> products = new ArrayList<>();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        int amount;
        String name, option;
        double price, customsFee;
        LocalDate manufactureDate;

        System.out.print("Enter the number of products: ");
        amount = Integer.parseInt(sc.nextLine());

        for(int i = 0; i < amount; i++) {
            Product product;
            System.out.printf("Product #%d data:\n", i+1);
            System.out.print("Common, used or imported (c/u/i)? ");
            option = sc.nextLine();
            System.out.print("Name: ");
            name = sc.nextLine();
            System.out.print("Price: ");
            price = Double.parseDouble(sc.nextLine());
            if(option.equals("c") || option.equals("C")) {
                product = new Product(name, price);
            } else if(option.equals("u") || option.equals("U")) {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                manufactureDate = LocalDate.parse(sc.nextLine(), fmt);
                product = new UsedProduct(name, price, manufactureDate);
            } else {
                System.out.print("Customs fee: ");
                customsFee = Double.parseDouble(sc.nextLine());
                product = new ImportedProduct(name, price, customsFee);
            }
            products.add(product);
            System.out.println(" ");
        }

        System.out.println("\nPRICE TAGS:");
        products.forEach(c -> System.out.println(c.priceTag()));
    }
}
