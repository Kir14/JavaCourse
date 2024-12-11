package modules.six.company.employee;

/*
•	Manager — зарплата складывается из фиксированной части и бонуса в виде 5% от заработанных для компании денег.
 Количество заработанных денег для компании генерируйте случайным образом от 115 000 до 140 000 рублей.
 */

import modules.six.company.Company;

public class Manager implements Employee {

    private int age;
    private double salaryFix;
    private Company company;
    private int interest;

    public Manager(int age) {
        this.age = age;
        interest = 5;
        salaryFix = (int) (Math.random() * 60_000) + 100_000;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalaryFix() {
        return salaryFix;
    }

    public void setSalaryFix(double salaryFix) {
        this.salaryFix = salaryFix;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public int getInterest() {
        return interest;
    }

    public void setInterest(int interest) {
        this.interest = interest;
    }

    @Override
    public double getMonthSalary() {
        return getSalaryFix() + interest / 100.0 * generateEarnedMoney();
    }

    private double generateEarnedMoney() {
        double maxMoney = 140_000;
        double minMoney = 115_000;
        return ((int) (Math.random() * (maxMoney - minMoney + 1)) + minMoney);
    }

    @Override
    public String toString() {
        return "Менеджер " + age + " лет, с зарплатой " + getMonthSalary();
    }
}
