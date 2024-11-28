package modules.six.bank;

import java.math.BigDecimal;

public class BankAccount {
    protected BigDecimal amount;

    public BankAccount() {
        amount = BigDecimal.valueOf(0.0);
    }

    public BankAccount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public boolean getSomeMoney(BigDecimal getAmount) {
        if (getAmount.compareTo(amount) > 0) {
            return false;
        }
        amount = amount.add(getAmount.negate());
        return true;
    }

    public void addMoney(BigDecimal plusAmount) {
        amount = amount.add(plusAmount);
    }
}
