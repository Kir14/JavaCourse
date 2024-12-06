package modules.six.company.employee;

/*
•	Manager — зарплата складывается из фиксированной части и бонуса в виде 5% от заработанных для компании денег.
 Количество заработанных денег для компании генерируйте случайным образом от 115 000 до 140 000 рублей.
 */

import modules.six.company.Company;

public class Manager extends Person implements Employee {

    private int interest;

    public Manager(String fullName, int age) {
        super(fullName, age);
        interest = 0;
    }

    public Manager(String fullName, int age, double salary, Company company) {
        super(fullName, age, salary, company);
        this.interest = 5;
    }

    public int getInterest() {
        return interest;
    }

    public void setInterest(int interest) {
        this.interest = interest;
    }

    @Override
    public double getMonthSalary() {
        return super.getSalaryFix() + interest * generateEarnedMoney();
    }

    private double generateEarnedMoney() {
        double maxMoney = 140_000;
        double minMoney = 115_000;
        return ((int) (Math.random() * (maxMoney - minMoney + 1)) + minMoney);
    }
}
