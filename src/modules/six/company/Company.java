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

    public void hire(Person person) {

        person.setCompany(this);

        if (person instanceof Operator) {
            employees.add((Operator) person);
            person.setSalaryFix((int) (Math.random() * 60_000) + 60_000);
        } else if (person instanceof Manager) {
            employees.add((Manager) person);
            ((Manager) person).setInterest(5);
            person.setSalaryFix((int) (Math.random() * 60_000) + 100_000);
        } else if (person instanceof TopManager) {
            employees.add((TopManager) person);
            ((TopManager) person).setBonus(150);
            person.setSalaryFix((int) (Math.random() * 60_000) + 130_000);
        }
    }

    public void hireAll(ArrayList<Person> persons) {
        for (Person person : persons) {
            hire(person);
        }
    }

    public void fire(Employee person) {

        if (person instanceof Operator) {
            employees.remove((Operator) person);
        } else if (person instanceof Manager) {
            employees.remove((Manager) person);
        } else if (person instanceof TopManager) {
            employees.remove((TopManager) person);
        }
        ((Person) person).setCompany(null);
        ((Person) person).setSalaryFix(0);
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
