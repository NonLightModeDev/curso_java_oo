import model.entities.Account;
import model.exceptions.DomainException;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        DecimalFormat dF = new DecimalFormat("0.00");
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter account data:");
            System.out.print("Number: ");
            int number = sc.nextInt();
            sc.nextLine(); // para consumir o caractere "\n" que foi deixado no buffer, pois o nextLine() é o único método "next" que consome até o "\n", os demais não consome o delimitador "\n"
            System.out.print("Holder: ");
            String holder = sc.nextLine();
            System.out.print("Initial balance: ");
            double balance = sc.nextDouble();
            sc.nextLine(); // para consumir o caractere "\n" que foi deixado no buffer
            System.out.print("Withdraw limit: ");
            double withdrawLimit = sc.nextDouble();
            sc.nextLine(); // para consumir o caractere "\n" que foi deixado no buffer
            Account account = new Account(number, holder, balance, withdrawLimit);

            System.out.print("\nEnter amount for withdraw: ");
            double amount = sc.nextDouble();
            sc.nextLine();
            account.withdraw(amount);
            System.out.println("New balance: " + dF.format(account.getBalance()));
        } catch(DomainException e) {
            System.out.println("Withdraw error: " + e.getMessage());
        } catch(Exception e) {
            System.out.println("Unexpected error. " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
