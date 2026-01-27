import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Worker worker = new Worker();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        int amountOfContracts = 0;

        System.out.print("Enter department's name: ");
        worker.setDepartment(new Department(sc.nextLine()));
        System.out.println("Enter worker data: ");
        System.out.print("Name: ");
        worker.setName(sc.nextLine());
        System.out.print("Level: ");
        worker.setLevel(WorkerLevel.valueOf(sc.nextLine()));
        System.out.print("Base salary: ");
        worker.setBaseSalary(Double.parseDouble(sc.nextLine()));
        System.out.print("How many contracts to this worker? ");
        amountOfContracts = Integer.parseInt(sc.nextLine());

        for(int i = 0; i < amountOfContracts; i++) {
            HourContract contract = new HourContract();
            System.out.printf("Enter contract #%d data:\n", i+1);
            System.out.print("Date (DD/MM/YYYY): ");
            contract.setDate(LocalDate.parse(sc.nextLine(), fmt));
            System.out.print("Value per hour: ");
            contract.setValuePerHour(Double.parseDouble(sc.nextLine()));
            System.out.print("Duration (hours): ");
            contract.setHours(Integer.parseInt(sc.nextLine()));
            worker.addContract(contract);
        }

        System.out.print("\n\nEnter month and year to calculate income (MM/YYYY): ");
        YearMonth date = YearMonth.parse(sc.nextLine(), DateTimeFormatter.ofPattern("MM/yyyy"));
        System.out.printf("Name: %s\n", worker.getName());
        System.out.printf("Department: %s\n", worker.getDepartment().getName());
        System.out.printf("Income for %s : %.2f", date, worker.income(date.getYear(), date.getMonthValue()));
    }
}
