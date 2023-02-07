import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        int operators = 180;
        int managers = 80;
        int topManagers = 10;

        ArrayList<String> employeesForHire = new ArrayList<>();

        // формирование списка для найма
        for (int operatorCount = 0; operatorCount < operators; operatorCount++) {
            employeesForHire.add("Operator");
        }
        for (int managerCount = 0; managerCount < managers; managerCount++) {
            employeesForHire.add("Manager");
        }
        for (int topManagerCount = 0; topManagerCount < topManagers; topManagerCount++) {
            employeesForHire.add("TopManager");
        }

        Company company = new Company();

        company.hireAll(employeesForHire);

        ArrayList<Employee> topSalary = new ArrayList<>(company.getTopSalaryStaff(15));
        System.out.println("Самые высокие зарплаты: ");

        for (Employee employee : topSalary) {
            System.out.println(employee);
        }

        ArrayList<Employee> revTopSalary = new ArrayList<>(company.getLowestSalaryStaff(30));
        System.out.println("Самые низкие зарплаты: ");
        for (Employee employee : revTopSalary) {
            System.out.println(employee);
        }

        int numberOfEmployees = company.employees.size();

        while (company.employees.size() > numberOfEmployees/2){
            company.fire(new Manager());
            company.fire(new Operator());
            company.fire(new Operator());
        }

        System.out.println(System.lineSeparator() + "Уволено 50% сотрудников" + System.lineSeparator());

        topSalary = new ArrayList<>(company.getTopSalaryStaff(15));
        System.out.println("Самые высокие зарплаты: ");

        for (Employee employee : topSalary) {
            System.out.println(employee);
        }

        revTopSalary = new ArrayList<>(company.getLowestSalaryStaff(30));
        System.out.println("Самые низкие зарплаты: ");

        for (Employee employee : revTopSalary) {
            System.out.println(employee);
        }

    }
}
