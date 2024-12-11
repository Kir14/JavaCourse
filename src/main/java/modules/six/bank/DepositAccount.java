package modules.six.bank;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;

public class DepositAccount extends BankAccount {

    private LocalDate lastIncome;

    public DepositAccount() {
        super();
    }

    public DepositAccount(BigDecimal amount) {
        super(amount);
        this.lastIncome = LocalDate.now();
    }

    public void setLastIncome(LocalDate ld) {
        lastIncome = ld;
    }

    public LocalDate getLastIncome() {
        return lastIncome;
    }

    @Override
    public void addMoney(BigDecimal amount) {
        super.addMoney(amount);
        lastIncome = LocalDate.now();
    }

    @Override
    public boolean getSomeMoney(BigDecimal getAmount) {
        if (Duration.between(lastIncome.atStartOfDay(), LocalDate.now().atStartOfDay()).toDays() < 31) {
            return false;
        }
        return super.getSomeMoney(getAmount);
    }

}
