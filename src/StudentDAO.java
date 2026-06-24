import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO {


    public void insertStudent(Student student) {

        try {

            Connection conn =
                    DBConnection.getConnection();

            String sql =
                    "INSERT INTO students(id,name,department) VALUES(?,?,?)";

            PreparedStatement pstmt =
                    conn.prepareStatement(sql);

            pstmt.setInt(
                    1,
                    student.getId());

            pstmt.setString(
                    2,
                    student.getName());

            pstmt.setString(
                    3,
                    student.getDepartment());

            int rows =
                    pstmt.executeUpdate();

            if(rows > 0) {

                System.out.println(
                        "✅ Student saved to database!");
            }

            conn.close();

        } catch(Exception e) {

            System.out.println(
                    "Database Error: "
                            + e.getMessage());
        }
    }


    public void displayDatabaseStudents() {

        try {

            Connection conn =
                    DBConnection.getConnection();

            String sql =
                    "SELECT * FROM students";

            PreparedStatement pstmt =
                    conn.prepareStatement(sql);

            ResultSet rs =
                    pstmt.executeQuery();

            System.out.println(
                    "\n===== DATABASE STUDENTS =====");

            while(rs.next()) {

                System.out.println(
                        rs.getInt("id")
                                + " | "
                                + rs.getString("name")
                                + " | "
                                + rs.getString("department"));
            }

            conn.close();

        } catch(Exception e) {

            System.out.println(
                    "Database Error: "
                            + e.getMessage());
        }
    }
}