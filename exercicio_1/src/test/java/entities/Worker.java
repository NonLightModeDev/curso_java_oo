package entities;

import entities.enums.WorkerLevel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Worker {
    private String name;
    private WorkerLevel level;
    private Double baseSalary;
    private List<HourContract> contracts;
    private Department department;

    public Worker() {
        contracts = new ArrayList<>();
    }

    public Worker(String name, WorkerLevel level, Double baseSalary, Department department, List<HourContract> contracts) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
        this.contracts = contracts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }

    public void addContract(HourContract contract) {
        contracts.add(contract);
    }

    public void removeContract(HourContract contract) {
        contracts.remove(contract);
    }

    public Double income(int year, int month) {
        List<HourContract> contractsFound = contracts
                .stream()
                .filter(c -> c.getDate().getYear() == year && c.getDate().getMonthValue() == month)
                .collect(Collectors.toList());
        List<Double> values = contractsFound.stream().map(c -> c.totalValue()).collect(Collectors.toList());
        double sumOfTheContractValues = values.stream().reduce(0.0, Double::sum);

        return baseSalary + sumOfTheContractValues;
    }
}
