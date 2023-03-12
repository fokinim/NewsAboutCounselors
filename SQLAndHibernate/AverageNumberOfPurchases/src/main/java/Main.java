import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "freetea8789";
        int countMonth = 0;
        int countSubscriptions = 0;

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();

            for (int i = 1; i < 13; i++) {

                String sqlQuery = "SELECT COUNT(*) FROM subscriptions WHERE MONTH(subscription_date) = " + i;
                ResultSet resultSet = statement.executeQuery(sqlQuery);

                while (resultSet.next()) {
                    String coursesAtMonth = resultSet.getString(1);
                    countSubscriptions += Integer.parseInt(coursesAtMonth);
                    countMonth = coursesAtMonth.equals("0") ? countMonth : countMonth + 1;
                }
            }

            float averageSubscriptions = (float) countSubscriptions / countMonth;

            System.out.println("Среднее количество покупок курсов в месяц: " + averageSubscriptions);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
