package modules.eight.exception.bank;

import modules.eight.exception.bank.account.BankAccount;
import modules.eight.exception.bank.exception.InsufficientFundsException;

public class MainBank {
    public static void main(String[] args) {
        BankAccount accountOne = new BankAccount("1234", 0);
        BankAccount accountTwo = new BankAccount("5678", 0);

        System.out.println();
        try{
            accountOne.deposit(-12);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println();
        try{
            accountOne.withdraw(12);
        } catch (InsufficientFundsException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println();
        try{
            accountOne.withdraw(-5);
        } catch (InsufficientFundsException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println();
        try{
            accountOne.deposit(25);
            accountTwo.deposit(10);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println();
        try{
            accountOne.transfer(null , 12);
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        } catch (InsufficientFundsException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println();
        try{
            accountOne.transfer(accountTwo , 30);
        } catch (NullPointerException | IllegalArgumentException | InsufficientFundsException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println();
        try{
            accountOne.transfer(accountTwo , -6);
        } catch (NullPointerException | IllegalArgumentException | InsufficientFundsException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println();
        try{
            accountOne.transfer(accountTwo , 12);
        } catch (NullPointerException | IllegalArgumentException | InsufficientFundsException ex) {
            System.out.println(ex.getMessage());
        }


    }
}
