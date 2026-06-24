import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        try {

            // Step 1: Load Driver
            Class.forName(
                    "com.mysql.cj.jdbc.Driver");

            // Step 2: Connect
            Connection conn =
                    DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/schooldb",
                            "root",
                            "");

            return conn;

        } catch (Exception e) {

            System.out.println(
                    "Database Error: "
                            + e.getMessage());
        }

        return null;
    }
}