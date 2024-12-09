package modules.six.company;

import modules.six.company.employee.*;

import java.util.List;

public class MainCompany {
    public static void main(String[] args) {
        Company company = new Company("KrilInterprise", 10_000_001);
        generateOperators(company, 6);
        generateManagers(company, 4);
        generateTopManagers(company, 2);
        System.out.println(company);
        outputAll(company.employees);

        System.out.println();
        System.out.println(" Top 5 salaries");
        outputAll(company.getTopSalaryStaff(5));

        System.out.println();
        System.out.println(" Lowest 6 salaries");
        outputAll(company.getLowestSalaryStaff(6));


        System.out.println("-----------FIRE--------------");
        for (int i = 0; i < company.employees.size(); i++) {
            company.fire(company.employees.get((int) (Math.random() * company.employees.size())));
        }
        System.out.println(company);
        outputAll(company.employees);

        System.out.println();
        System.out.println(" Top 5 salaries");
        outputAll(company.getTopSalaryStaff(5));

        System.out.println();
        System.out.println(" Lowest 6 salaries");
        outputAll(company.getLowestSalaryStaff(6));

        System.out.println();
        System.out.println(" Lowest 8 salaries");
        outputAll(company.getLowestSalaryStaff(8));

    }

    public static void generateOperators(Company company, int count) {
        for (int i = 0; i < count; i++) {
            company.hire(new Operator("Name", (int) (Math.random() * 11) + 20));
        }
    }

    public static void generateManagers(Company company, int count) {
        for (int i = 0; i < count; i++) {
            company.hire(new Manager("Name", (int) (Math.random() * 11) + 30));
        }
    }

    public static void generateTopManagers(Company company, int count) {
        for (int i = 0; i < count; i++) {
            company.hire(new TopManager("Name", (int) (Math.random() * 11) + 40));
        }
    }

    public static void outputAll(List<Employee> people) {
        if (people == null)
            return;
        for (Employee p : people) {
            System.out.println(p);
        }
    }
}
