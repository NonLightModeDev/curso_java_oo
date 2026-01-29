package entities;

public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount() {
        super();
    }

    public SavingsAccount(int number, String holder, double balance, double interestRate) {
        super(number, holder, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void updateBalance() {
        balance *= (1 + interestRate);
    }

    @Override // é bom utilizar porque o compilador vai verificar se existe um método com esse nome na superclasse, assim, se o nome for escrito errado, o comppilador vai avisar, porque não existe um método na superclasse com esse nome
    // se não utilizar a anotação @Override, caso escreva o nome errado, o compilador não irá acusar, pois vai achar que é um novo método da classe
    public void withdraw(double amount) {
        balance -= amount;
    }
}
