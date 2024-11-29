package modules.five.map.homework;

public class MainBank {
    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.addClient(14231, new BankAccount("Kirill", "USD"));
        bank.addClient(5677, new BankAccount("Valera", "USD"));
        bank.addClient(1235, new BankAccount("Misha", "EUR"));
        bank.addClient(111, new BankAccount("Oleg", "EUR"));
        bank.addClient(1243566, new BankAccount("Denisssss", "BYN"));
        bank.addClient(1243566, new BankAccount("Denis", "BYN"));

        System.out.print(bank.getAllClient());
        System.out.println("-------------------------------------------");

        System.out.println(bank.addMoney(123, 3000));
        System.out.println(bank.addMoney(12354, 3000));

        System.out.println(bank.addMoney(14231, 5_000));
        System.out.println(bank.addMoney(14231, 500));
        System.out.println(bank.addMoney(14231, 150));
        System.out.println(bank.addMoney(1235, 2_300));
        System.out.println(bank.addMoney(111, 3400));
        System.out.println(bank.addMoney(14231, 5_000));

        System.out.print(bank.getAllClient());
        System.out.println("-------------------------------------------");

        System.out.print(bank.getClientSorted() );
        System.out.println("-------------------------------------------");

        System.out.println(bank.getMoney(111111, 3500));
        System.out.println(bank.getMoney(111, 3500));
        System.out.println(bank.getMoney(111, 3200));
        System.out.println(bank.getBalance(111));
        System.out.println("-------------------------------------------");

        System.out.println(bank.send(1, 5677, 2_000));
        System.out.println(bank.send(14231, 56, 2_000));
        System.out.println(bank.send(14231, 5677, 2_000));
        System.out.println(bank.getAllClient());
        System.out.println("-------------------------------------------");




    }
}
