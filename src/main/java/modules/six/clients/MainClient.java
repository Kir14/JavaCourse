package modules.six.clients;

/*
1. Создайте классы, представляющие клиентов банка: абстрактный класс Client, классы для физических лиц, юридических лиц и индивидуальных предпринимателей.
У каждого клиента есть сумма денег на счету (число). Деньги можно положить на счёт, снять и вернуть остаток на счёте.
Каждый класс должен содержать метод, который выводит информацию в консоль о счёте: условие пополнения, условие снятия и баланс.
2. Реализуйте методы, при которых:
•	У физических лиц пополнение и снятие происходит без комиссии.
•	У юридических лиц — снятие с комиссией 1%.
•	У ИП — пополнение с комиссией 1%, если сумма меньше 1000 рублей. И с комиссией 0,5%, если сумма больше либо равна 1000 рублей.

 */


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MainClient {
    public static void main(String[] args) {
        FizClient fizClient = new FizClient(BigDecimal.valueOf(1_000));
        System.out.println(fizClient);
        System.out.println("Накинули 3_000");
        fizClient.addMoney(BigDecimal.valueOf(3_000));
        System.out.println(fizClient);
        System.out.println("Сняли 4_000");
        fizClient.getSomeMoney(BigDecimal.valueOf(4_000));
        System.out.println(fizClient);

        System.out.println("========================================================");

        YrClient yrClient = new YrClient();
        yrClient.addMoney(BigDecimal.valueOf(7_000));
        System.out.println(yrClient);

        System.out.println("========================================================");

        IPClient ipClient = new IPClient();
        ipClient.addMoney(BigDecimal.valueOf(4_500));
        System.out.println(ipClient);

        System.out.println("======LIST===========LIST==========LIST======");


        ArrayList<Client> list = new ArrayList<>();
        list.add(fizClient);
        list.add(yrClient);
        list.add(ipClient);

        output(list);

        for (Client cl : list) {
            cl.addMoney(BigDecimal.valueOf(3_500));
        }

        System.out.println("======LIST=======AFTER add 3_500=======LIST======");
        output(list);

        for (Client cl : list) {
            cl.getSomeMoney(BigDecimal.valueOf(2_000));
        }

        System.out.println("======LIST=======AFTER get 2_000=======LIST======");
        output(list);

    }

    public static void output(List<Client> list) {
        for (Client cl : list) {
            System.out.println(cl);
            System.out.println();
        }
    }
}
