package modules.six.company.employee;

import modules.six.company.Company;

public class Person {

    //TODO fullName is difficult to generate. Delete it
    private String fullName;
    private int age;
    private double salaryFix;
    private Company company;

    public Person(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
        salaryFix = 0;
        company = null;
    }

    public Person(String fullName, int age, double salary, Company company) {
        this(fullName, age);
        this.salaryFix = salary;
        this.company = company;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public double getSalaryFix() {
        return salaryFix;
    }

    public void setSalaryFix(double salary) {
        this.salaryFix = salary;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //TODO write toString()

}
