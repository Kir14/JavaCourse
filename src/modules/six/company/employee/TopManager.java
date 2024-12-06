package modules.six.company.employee;

/*
•	TopManager — зарплата складывается из фиксированной части
и бонуса в виде 150% от заработной платы, если доход компании более 10 млн рублей.
 */

import modules.six.company.Company;

public class TopManager extends Person implements Employee {

    private int bonus;

    public TopManager(String fullName, int age) {
        super(fullName, age);
        bonus = 0;
    }

    public TopManager(String fullName, int age, double salary, Company company) {
        super(fullName, age, salary, company);
        bonus = 150;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public double getMonthSalary() {
        double maxIncome = 10_000_000;
        return super.getSalaryFix() + super.getSalaryFix() * (super.getCompany().getIncome() > maxIncome ? bonus : 0) / 100.0;
    }
}
