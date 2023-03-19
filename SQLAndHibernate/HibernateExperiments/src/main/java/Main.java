import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml").build();
            Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
            SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

            Session session = sessionFactory.openSession();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Purchase> query = builder.createQuery(Purchase.class);
            Root<Purchase> root = query.from(Purchase.class);
            query.select(root);

            List<Purchase> purchaseList = session.createQuery(query).getResultList();

            String url = "jdbc:mysql://localhost:3306/hibernate";
            String user = "root";
            String pass = "freetea8789";
            int courseId = 0;
            int studentId = 0;

            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();

            for (Purchase purchase : purchaseList) {

                String sqlQueryCourse = "SELECT id FROM Courses WHERE name = '" + purchase.getId().getCourseName() + "'";
                ResultSet courseResultSet = statement.executeQuery(sqlQueryCourse);

                while (courseResultSet.next()) {
                    courseId = Integer.parseInt(courseResultSet.getString(1));
                }

                String sqlQueryStudent = "SELECT id FROM Students WHERE name = '" + purchase.getId().getStudentName() + "'";
                ResultSet studentResultSet = statement.executeQuery(sqlQueryStudent);

                while (studentResultSet.next()) {
                    studentId = Integer.parseInt(studentResultSet.getString(1));
                }

                Transaction transaction = session.beginTransaction();

                LinkedPurchase linkedPurchase = new LinkedPurchase();
                linkedPurchase.setId(new LinkedPurchaseKey(studentId, courseId));

                session.save(linkedPurchase);
                transaction.commit();
            }

            sessionFactory.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
