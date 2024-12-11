package modules.six.clients;

import java.math.BigDecimal;

/*
2. Реализуйте методы, при которых:
•	У физических лиц пополнение и снятие происходит без комиссии.

Каждый класс должен содержать метод, который выводит информацию в консоль о счёте: условие пополнения, условие снятия и баланс.
 */

public class FizClient extends Client {

    public FizClient() {
        super();
    }

    public FizClient(BigDecimal amount) {
        super(amount);
    }

    @Override
    public boolean getSomeMoney(BigDecimal getAmount) {
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
        return "Счет физлица.\nСнятие и пополнение производится без комиссии.\nОстаток: " + amount;
    }
}
