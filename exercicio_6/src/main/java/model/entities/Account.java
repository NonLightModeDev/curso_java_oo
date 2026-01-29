package model.entities;

import model.exceptions.DomainException;

public class Account {
    private int number;
    private String holder;
    private double balance;
    private double withdrawLimit;

    public Account() {
        super();
    }

    public Account(int number, String holder, double balance, double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public int getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public double getBalance() {
        return balance;
    }

    public double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public double withdraw(double amount) throws DomainException {
        if(amount > balance) {
            throw new DomainException("Insufficient balance");
        }
        if(amount > withdrawLimit) {
            throw new DomainException("The amount exceeds withdraw limit");
        }

        balance -= amount;

        return amount;
    }
}
