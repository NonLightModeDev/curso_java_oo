package applications;

import model.entities.Contract;
import model.services.ContractService;
import model.services.PaypalService;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Program {
    private static final DecimalFormat dFmt = new DecimalFormat("0.00");
    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(System.in);
            System.out.println("Entre com os dados do contrato:");
            System.out.print("Número: ");
            int contractNumber = sc.nextInt();
            sc.nextLine();
            System.out.print("Data (dd/MM/yyyy): ");
            LocalDate contractDate = LocalDate.parse(sc.nextLine(), fmt);
            System.out.print("Valor do contrato: ");
            double contractTotalValue = sc.nextDouble();
            System.out.print("Entre com o número de parcelas: ");
            int contractMonths = sc.nextInt();
            sc.nextLine();

            Contract contract = new Contract(contractNumber, contractDate, contractTotalValue);
            ContractService contractService = new ContractService(new PaypalService());
            contractService.processContract(contract, contractMonths);

            System.out.println("\nParcelas");
            contract.getInstallments().forEach(installment -> {
                System.out.println(installment.getDueDate().format(fmt) + " - " + dFmt.format(installment.getAmount()));
            });

        } catch(DateTimeParseException e) {
            System.out.println(e.getMessage());
        } finally {
            if(sc != null) {
                sc.close();
            }
        }
    }
}
