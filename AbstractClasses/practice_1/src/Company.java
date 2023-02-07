import java.util.ArrayList;
import java.util.Comparator;

public class Company {

    public ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<Employee> topSalary = new ArrayList<>();
    Comparator<Employee> bySalary = Comparator.comparing(Employee::getMonthSalary);
    public double companyIncome;
    public static double managerIncome;

    public void hire(Employee employee){

        employees.add(employee);

        if (employee.getClass().getName().equals("Manager")){
            companyIncome += managerIncome;
            managerIncome = 0;
        }
    }

    public void hireAll(ArrayList<String> employeesForHire){
        for (String name : employeesForHire) {
            switch (name) {
                case "Manager" -> hire(new Manager());
                case "Operator" -> hire(new Operator());
                case "TopManager" -> hire(new TopManager(companyIncome));
            }
        }
    }

    public void fire(Employee employee){
        for(int i = 0; i < employees.size(); i++) {

            String objForDelete = employee.getClass().getName();
            String objFromList = employees.get(i).getClass().getName();

            if (objForDelete.equals(objFromList)) {
                employees.remove(i);
                return;
            }
        }
    }

    public double getIncome(){
        return companyIncome;
    }

    public ArrayList<Employee> getTopSalaryStaff(int count){

        topSalary.clear();
        employees.sort(bySalary);

        for (int i = 0; i < count; i++){
            int index = employees.size() - 1 - i;
            topSalary.add(employees.get(index));
        }
        return topSalary;
    }

    public ArrayList<Employee> getLowestSalaryStaff(int count){

        topSalary.clear();
        employees.sort(bySalary);

        for (int i = 0; i < count; i++){

            topSalary.add(employees.get(i));
        }
        return topSalary;
    }

    public String toString(){
        String employeesList = "";

        for (Employee employee : employees) {

            employeesList = String.join(System.lineSeparator(), employeesList,
                    employee.toString());
        }
        return employeesList;
    }
}
