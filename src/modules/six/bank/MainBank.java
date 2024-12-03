package modules.six.bank;

/*
1. Создайте класс BankAccount, который представляет собой расчётный счёт в банке. У класса необходимо написать методы:
     a. Снять со счёта сумму денег (без комиссии).
     b. Вносить на счёт сумму денег (без комиссии).
     c. Получить остаток на счёте.
2. Создайте два класса наследника, расширяющие работу с остатком на счёте:
•	Депозитный расчётный счёт, с которого нельзя снимать деньги в течение месяца после последнего внесения.
•	Карточный счёт, при снятии денег с которого будет взиматься комиссия 1%.

Напишите метод в классе BankAccount:
boolean send(BankAccount receiver, double amount)
для отправки денег с одного счёта на другой. Метод должен вернуть true, если деньги успешно переведены.
Примечание
В методе для аргумента amount используйте тип данных, который применили в классе BankAccount. Тип double дан для примера.

 */

import java.math.BigDecimal;
import java.time.LocalDate;

public class MainBank {
    public static void main(String[] args) {
        System.out.println("Deposit account");
        DepositAccount da = new DepositAccount();
        System.out.println("Положить 10_000");
        da.addMoney(BigDecimal.valueOf(10_000));
        System.out.println(da.getAmount());
        System.out.println("Последнее поступление");
        System.out.println(da.getLastIncome());
        System.out.println(da.getSomeMoney(BigDecimal.valueOf(11_000)));
        da.setLastIncome(LocalDate.now().minusDays(31));
        System.out.println("Последнее поступление");
        System.out.println(da.getLastIncome());
        System.out.println("Снятие 11_000");
        System.out.println(da.getSomeMoney(BigDecimal.valueOf(11_000)));
        System.out.println("Снятие 3_000");
        System.out.println(da.getSomeMoney(BigDecimal.valueOf(3_000)));
        System.out.println(da.getAmount());

        System.out.println("Card account");
        CardAccount ca = new CardAccount(BigDecimal.valueOf(10), BigDecimal.valueOf(10_000));
        System.out.println(ca.getAmount());
        System.out.println("Снятие 3_000 с процентом " + ca.getInterest());
        System.out.println(ca.getSomeMoney(BigDecimal.valueOf(3_000)));
        System.out.println(ca.getAmount());
        System.out.println("положить 3_000");
        ca.addMoney(BigDecimal.valueOf(3_000));
        System.out.println(ca.getAmount());

        System.out.println("Before transaction send 4_000");
        System.out.println(da.getAmount());
        System.out.println(ca.getAmount());
        System.out.println("After send 4_000");
        da.send(ca, BigDecimal.valueOf(4_000));
        System.out.println(da.getAmount());
        System.out.println(ca.getAmount());

        CardAccount card = new CardAccount(BigDecimal.valueOf(10), BigDecimal.valueOf(1_000));
        System.out.println(card.getAmount());
        System.out.println(card.getSomeMoney(BigDecimal.valueOf(1_000)));
        System.out.println(card.getAmount());
    }
}
