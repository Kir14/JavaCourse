package modules.six.clients;

/*
У юридических лиц — снятие с комиссией 1%.
Каждый класс должен содержать метод, который выводит информацию в консоль о счёте: условие пополнения, условие снятия и баланс.
 */

import java.math.BigDecimal;

public class YrClient extends Client {

    private BigDecimal interest;

    public YrClient() {
        super();
        this.interest = BigDecimal.valueOf(1);
    }

    public YrClient(BigDecimal interest) {
        super();
        this.interest = interest;
    }

    public YrClient(BigDecimal interest, BigDecimal amount) {
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
        getAmount = getAmount.multiply(interest.divide(BigDecimal.valueOf(100)).add(BigDecimal.valueOf(1)));
        if (getAmount.compareTo(amount) > 0) {
            return false;
        }
        amount = amount.add(getAmount.negate());
        return true;
    }

    @Override
    public void addMoney(BigDecimal plusAmount) {
        amount = amount.add(plusAmount);
    }

    @Override
    public String toString() {
        return "Счет юрлица.\nПополнение производится без комиссии.\nПри снятии берется комиссия " + interest + "%.\nОстаток: " + amount;
    }
}
