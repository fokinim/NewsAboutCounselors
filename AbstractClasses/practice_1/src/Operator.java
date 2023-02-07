public class Operator implements Employee{

    private double monthSalary;

    public Operator() {
        monthSalary = Employee.OPERATOR_FIX_PART;
    }

    @Override
    public double getMonthSalary() {

        return monthSalary;
    }

    public String toString() {
        String operatorSalary = monthSalary + " руб.";
        return operatorSalary;
    }
}
