package modules.six.clients;

/*
У ИП — пополнение с комиссией 1%, если сумма меньше 1000 рублей. И с комиссией 0,5%, если сумма больше либо равна 1000 рублей.
Каждый класс должен содержать метод, который выводит информацию в консоль о счёте: условие пополнения, условие снятия и баланс.
 */

import java.math.BigDecimal;

public class IPClient extends Client {

    private BigDecimal interestAboveThousand;
    private BigDecimal interestUnderThousand;

    public IPClient() {
        interestAboveThousand = BigDecimal.valueOf(0.5);
        interestUnderThousand = BigDecimal.valueOf(1);
    }

    public IPClient(BigDecimal interestAboveThousand, BigDecimal interestUnderThousand) {
        this.interestAboveThousand = interestAboveThousand;
        this.interestUnderThousand = interestUnderThousand;
    }

    public IPClient(BigDecimal amount, BigDecimal interestUnderThousand, BigDecimal interestAboveThousand) {
        super(amount);
        this.interestUnderThousand = interestUnderThousand;
        this.interestAboveThousand = interestAboveThousand;
    }

    public BigDecimal getInterestAboveThousand() {
        return interestAboveThousand;
    }

    public void setInterestAboveThousand(BigDecimal interestAboveThousand) {
        this.interestAboveThousand = interestAboveThousand;
    }

    public BigDecimal getInterestUnderThousand() {
        return interestUnderThousand;
    }

    public void setInterestUnderThousand(BigDecimal interestUnderThousand) {
        this.interestUnderThousand = interestUnderThousand;
    }

    @Override
    public boolean getSomeMoney(BigDecimal getAmount) {
        if (getAmount.compareTo(amount) > 0) {
            return false;
        }
        amount = amount.add(getAmount.negate());
        return true;
    }

    //пополнение с комиссией 1%, если сумма меньше 1000 рублей. И с комиссией 0,5%, если сумма больше либо равна 1000 рублей.
    public void addMoney(BigDecimal plusAmount) {
        if (plusAmount.compareTo(BigDecimal.valueOf(1000)) < 0) {
            amount = amount.add(plusAmount.multiply(BigDecimal.valueOf(1).add(interestUnderThousand.divide(BigDecimal.valueOf(100)).negate())));
        } else {
            amount = amount.add(plusAmount.multiply(BigDecimal.valueOf(1).add(interestAboveThousand.divide(BigDecimal.valueOf(100)).negate())));
        }
    }

    public String toString() {
        return "Счет ИП.\nСнятие производится без комиссии.\n" +
                "Пополнение производится с комиссией 1%, если сумма меньше 1000 рублей. И с комиссией 0,5%, если сумма больше либо равна 1000 рублей.\n" + "Остаток: " + amount;
    }
}
