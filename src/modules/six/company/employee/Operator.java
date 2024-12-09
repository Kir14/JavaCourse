package modules.six.company.employee;

public class Operator extends Person implements Employee {

    public Operator(String fullName, int age) {
        super(fullName, age);
    }

    @Override
    public double getMonthSalary() {
        return getSalaryFix();
    }

    @Override
    public String toString() {
        return super.toString() + ", Оператор с зарплатой " + getMonthSalary();
    }
}
