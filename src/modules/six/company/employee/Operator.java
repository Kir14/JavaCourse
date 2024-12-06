package modules.six.company.employee;

import modules.six.company.Company;

public class Operator extends Person implements Employee {

    public Operator(String fullName, int age) {
        super(fullName, age);
    }

    public Operator(String fullName, int age, double salary, Company company) {
        super(fullName, age, salary, company);
    }

    @Override
    public double getMonthSalary() {
        return getSalaryFix();
    }
}
