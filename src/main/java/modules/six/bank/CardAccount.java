package modules.six.bank;

import java.math.BigDecimal;

public class CardAccount extends BankAccount {
    private BigDecimal interest;

    public CardAccount(BigDecimal interest) {
        super();
        this.interest = interest;
    }

    public CardAccount(BigDecimal interest, BigDecimal amount) {
        super(amount);
        this.interest = interest;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    @Override
    public boolean getSomeMoney(BigDecimal getAmount) {
        return super.getSomeMoney(getAmount.add(getAmount.multiply(interest.divide(BigDecimal.valueOf(100)))));
    }
}
