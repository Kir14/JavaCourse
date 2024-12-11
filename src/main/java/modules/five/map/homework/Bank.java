package modules.five.map.homework;

import java.util.*;

public class Bank {
    HashMap<Integer, BankAccount> bank;

    public Bank() {
        bank = new HashMap<>();
    }

    /*
     Добавление нового клиента:
   - Напишите метод, который добавляет новый банковский счет для клиента. Если клиент с таким ID уже существует, необходимо обновить его данные.
     */
    public int addClient(Integer idClient, BankAccount account) {
        if (bank.containsKey(idClient)) {
            BankAccount acc = bank.get(idClient);
            if (!acc.getClientName().equals(account.getClientName())) {
                acc.setClientName(account.getClientName());
            }
            if (!acc.getCurrency().equals(account.getCurrency())) {
                acc.setCurrency(account.getCurrency());
            }
            return -1;
        } else {
            bank.put(idClient, account);
            return 1;
        }
    }

    /*
    Пополнение счета:
   - Напишите метод, который позволяет пополнить счет клиента на указанную сумму. Если клиента нет в системе, вывести сообщение "Клиент не найден".
     */
    public String addMoney(Integer idClient, double money) {
        if (bank.containsKey(idClient)) {
            bank.get(idClient).addMoney(money);
            return "Сумма зачислена";
        } else {
            return "Клиент не найден";
        }
    }

    /*
    Снятие средств:
   - Напишите метод, который позволяет снять средства с счета клиента. Если средств недостаточно, вывести сообщение "Недостаточно средств".
   Если клиента нет в системе, вывести сообщение "Клиент не найден".
     */
    public String getMoney(Integer idClient, double money) {
        if (!bank.containsKey(idClient)) {
            return "Клиент не найден";
        }
        if (bank.get(idClient).getMoney(money)) {
            return "Средства списаны со счета";
        } else {
            return "Недостаточно средств";
        }
    }

    /*
    Перевод средств между счетами:
   - Напишите метод, который позволяет перевести средства с одного счета на другой. Если один из клиентов не найден,
   вывести сообщение "Один из клиентов не найден". Если средств недостаточно на счете отправителя, вывести "Недостаточно средств".
     */
    public String send(Integer idClSender, Integer idClReceiver, double money) {
        if (!bank.containsKey(idClSender) || !bank.containsKey(idClReceiver)) {
            return "Один из клиентов не найден";
        }
        if (bank.get(idClSender).getMoney(money)) {
            bank.get(idClReceiver).addMoney(money);
            return "Средства переведены";
        } else {
            return "Недостаточно средств";
        }
    }

    /*
    Проверка баланса:
   - Напишите метод, который позволяет клиенту проверить свой баланс по ID.
     */
    public double getBalance(Integer idClient) {
        return bank.get(idClient).getBalance();
    }

    public String getAllClient() {
        StringBuilder sb = new StringBuilder();
        for (Integer idCl : bank.keySet()) {
            sb.append(idCl).append(" ").append(bank.get(idCl).toString()).append("\n");
        }
        return sb.toString();
    }

    /*
    Вывод всех счетов в порядке убывания баланса:
   - Напишите метод, который выводит всех клиентов в порядке убывания их баланса.
     */
    public String getClientSorted() {
        List<BankAccount> accs = new ArrayList<>(bank.values());
        accs.sort(Comparator.comparing(BankAccount::getBalance, Collections.reverseOrder()));
        StringBuilder sb = new StringBuilder();
        for (BankAccount acc : accs) {
            sb.append(acc.toString()).append("\n");
        }
        return sb.toString();
    }

}
