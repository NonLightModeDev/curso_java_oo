package model.services;

import model.entities.Contract;
import model.entities.Installment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContractService {
    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, int months) {
        double baseInstallmentValue = contract.getTotalValue() / months;
        List<Installment> installments = new ArrayList<>();
        LocalDate dueDate;
        double interest;
        double amount;

        for(int i = 0; i < months; i++) {
            dueDate = contract.getDate().plusMonths(i+1);
            interest = onlinePaymentService.interest(baseInstallmentValue, i+1);
            amount = baseInstallmentValue + interest;
            amount += onlinePaymentService.paymentFee(amount);
            installments.add(new Installment(dueDate, amount));
        }
        contract.setInstallments(installments);
    }
}
