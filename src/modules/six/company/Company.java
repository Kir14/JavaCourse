package modules.six.company;

/*
Создайте класс компании Company, содержащей сотрудников и реализующей методы:
•	найм одного сотрудника — hire(),
•	найм списка сотрудников – hireAll(),
•	увольнение сотрудника – fire(),
•	получение значения дохода компании – getIncome().
Аргументы и возвращаемое значение методов выберите на основании логики работы вашего приложения.
2. Создайте два метода, возвращающие список указанной длины (count). Они должны содержать сотрудников, отсортированных по убыванию и возрастанию заработной платы:
•	List<Employee> getTopSalaryStaff(int count),
•	List<Employee> getLowestSalaryStaff(int count).
 */

import modules.six.company.employee.Person;

import java.util.ArrayList;

public class Company {

    private String companyName;
    private double income;
    public ArrayList<Person> employees;

    public Company(String companyName, double income) {
        this.companyName = companyName;
        this.income = income;
        employees = new ArrayList<>();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public void hire(Person person) {
        employees.add(person);
        person.setCompany(this);
        person.setSalaryFix((int) (Math.random() * 61) + 60);
    }

    public void hireAll(ArrayList<Person> persons) {
        for (Person person : persons) {
            hire(person);
        }
    }

    public void fire(Person p) {
        employees.remove(p);
        p.setCompany(null);
        p.setSalaryFix(0);
    }


}
