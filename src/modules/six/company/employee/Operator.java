package modules.six.company.employee;

import modules.six.company.Company;

public class Operator implements Employee {

    private int age;
    private double salaryFix;
    private Company company;

    public Operator(int age) {
        this.age = age;
        salaryFix = (int) (Math.random() * 60_000) + 60_000;
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

    @Override
    public double getMonthSalary() {
        return getSalaryFix();
    }

    @Override
    public String toString() {
        return "Оператор " + age + " лет, с зарплатой " + getMonthSalary();
    }
}
