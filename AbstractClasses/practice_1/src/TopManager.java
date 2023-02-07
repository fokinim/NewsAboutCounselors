public class TopManager implements Employee{

    private double bonus;
    private double monthSalary;

    public TopManager(double companyIncome) {
        if (companyIncome > 10_000_000) {
            bonus = Employee.TOP_MANAGER_FIX_PART * 1.5;
        }
        monthSalary = Employee.TOP_MANAGER_FIX_PART + bonus;

    }

    @Override
    public double getMonthSalary() {

        return monthSalary;
    }

    public String toString() {
        String topManagerSalary = monthSalary + " руб.";
        return topManagerSalary;
    }
}
