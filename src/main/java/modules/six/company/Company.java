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

import modules.six.company.employee.*;

import modules.six.company.employee.Employee;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class Company {

    private String companyName;
    private double income;
    public ArrayList<Employee> employees;

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

    public void hire(Employee person) {
        person.setCompany(this);
        employees.add(person);
    }

    public void hireAll(ArrayList<Employee> persons) {
        for (Employee person : persons) {
            hire(person);
        }
    }

    public void fire(Employee person) {
        employees.remove(person);
        person.setCompany(null);
    }

    /*
    Создайте два метода, возвращающие список указанной длины (count). Они должны содержать сотрудников, отсортированных по убыванию и возрастанию заработной платы:
    List<Employee> getTopSalaryStaff(int count),
•	List<Employee> getLowestSalaryStaff(int count)
     */

    List<Employee> getLowestSalaryStaff(int count) {
        if (count < 1 || count > employees.size()) {
            return null;
        }
        employees.sort(Comparator.comparingDouble(Employee::getMonthSalary));
        return employees.subList(0, count - 1);
    }

    List<Employee> getTopSalaryStaff(int count) {
        if (count < 1 || count > employees.size()) {
            return null;
        }
        employees.sort((o1, o2) -> ((Double) o2.getMonthSalary()).compareTo(o1.getMonthSalary()));
        return employees.subList(0, count - 1);
    }

    @Override
    public String toString() {
        return "Компания " + companyName + ", количество сотрудников " + employees.size()
                + ", доход компании " + String.format(Locale.FRANCE, "%,.2f", income);
    }


}
