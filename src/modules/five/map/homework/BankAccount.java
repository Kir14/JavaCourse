package modules.five.map.homework;

public class BankAccount {
    private String clientName;
    private double balance;
    private final String currency;

    public BankAccount(String clientName, String currency) {
        this.clientName = clientName;
        this.currency = currency;
        balance = 0;
    }

    public void addMoney(double money) {
        balance += money;
    }

    public boolean getMoney(double money) {
        if (money > balance) {
            return false;
        }
        balance -= money;
        return true;
    }

    public double getBalance() {
        return balance;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return clientName + " Остаток на счете: " + balance + " " + currency;
    }

}
