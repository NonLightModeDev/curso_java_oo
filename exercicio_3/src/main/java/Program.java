import entities.Employee;
import entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int amount;

        System.out.print("How much employees? ");
        amount = Integer.parseInt(sc.nextLine());

        for(int i = 0; i < amount; i++) {
            Employee employee;
            String response;
            String name;
            int hours;
            double valuePerHour;

            System.out.printf("Enter employee #%d data:\n", i+1);
            System.out.print("Outsourced employee (y/n)? ");
            response = sc.nextLine();
            System.out.print("Enter the employee's name: ");
            name = sc.nextLine();
            System.out.print("Enter value per hour: ");
            valuePerHour = Double.parseDouble(sc.nextLine());
            System.out.print("Enter hours: ");
            hours = Integer.parseInt(sc.nextLine());
            if(response.equals("y") || response.equals("Y")) {
                System.out.print("Enter additional charge: ");
                double additionalCharge = Double.parseDouble(sc.nextLine());
                employee = new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge);
            } else {
                employee = new Employee(name, hours, valuePerHour);
            }
            employees.add(employee);
            System.out.println("");
        }

        System.out.print("\nList of employees: ");
        employees.forEach(employee -> {
            System.out.printf("\n- Employee %s:", employee.getName());
            System.out.printf("\n\tPayment: %.2f", employee.payment());
        });
    }
}
