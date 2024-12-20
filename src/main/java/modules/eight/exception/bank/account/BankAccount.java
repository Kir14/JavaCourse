package modules.eight.exception.bank.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import modules.eight.exception.bank.exception.InsufficientFundsException;

@AllArgsConstructor
@Getter
@Setter
public class BankAccount {
    private String accountNumber;
    private double balance;

    public void deposit(double amount) {
        System.out.println("Пополнение на '"+ amount +"' счета " + accountNumber + " , до операции остаток " + balance);
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма должна быть положительной");
        }
        balance += amount;
        System.out.println(this);
    }

    public void withdraw(double amount) throws InsufficientFundsException{
        System.out.println("Снятие '"+ amount +"' со счета " + accountNumber + " , до операции остаток " + balance);
        if (amount > balance) {
            throw new InsufficientFundsException("Недостаточно средств на счете " + accountNumber);
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма должна быть положительной");
        }
        balance -= amount;
        System.out.println(this);
    }

    public void transfer(BankAccount targetAccount, double amount) throws InsufficientFundsException {
        System.out.println("Перевод '" + amount + "' с " + this + " на " + targetAccount);
        if (targetAccount == null) {
            throw new NullPointerException("Нет счета-получателя");
        }
        withdraw(amount);
        targetAccount.deposit(amount);
        System.out.println(this);
        System.out.println(targetAccount);
    }

    @Override
    public String toString() {
        return "Счет " + accountNumber + " баланс: " + balance;
    }
}
