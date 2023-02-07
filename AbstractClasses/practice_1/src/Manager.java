public class Manager implements Employee{

    private double monthSalary;

    public Manager() {
        Company.managerIncome = (int)(Math.random() * (140000 - 115000 + 1) + 115000);
        monthSalary = Employee.MANAGER_FIX_PART + Company.managerIncome * 0.05;
    }

    @Override
    public double getMonthSalary() {

        return monthSalary;
    }

    public String toString() {
        String managerSalary = monthSalary + " руб.";
        return managerSalary;
    }
}
