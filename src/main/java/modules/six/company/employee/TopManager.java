package modules.six.company.employee;

/*
•	TopManager — зарплата складывается из фиксированной части
и бонуса в виде 150% от заработной платы, если доход компании более 10 млн рублей.
 */

import modules.six.company.Company;

public class TopManager implements Employee {

    private int age;
    private double salaryFix;
    private Company company;
    private int bonus;

    final double MAX_INCOME = 10_000_000;

    public TopManager(int age) {
        this.age = age;
        bonus = 150;
        salaryFix = (int) (Math.random() * 60_000) + 130_000;
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

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public double getMonthSalary() {
        return getSalaryFix() + getSalaryFix() * (company.getIncome() > MAX_INCOME ? bonus : 0) / 100.0;
    }

    @Override
    public String toString() {
        return "ТопМенеджер " + age + " лет, с зарплатой " + getMonthSalary();
    }
}
