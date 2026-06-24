import java.util.ArrayList;

public class School {

    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {

        students.add(student);

        System.out.println(
                "\n Student Registered Successfully!");
    }

    public void displayStudents() {

        if (students.isEmpty()) {

            System.out.println(
                    "\n No students registered.");

            return;
        }

        System.out.println(
                "\n===== STUDENT LIST =====");

        for (Student student : students) {

            student.display();
        }
    }

    public Student searchStudent(int id) {

        for (Student student : students) {

            if (student.getId() == id) {

                return student;
            }
        }

        return null;
    }

    public boolean updateStudent(
            int id,
            String newName,
            String newDepartment) {

        Student student = searchStudent(id);

        if (student != null) {

            student.setName(newName);
            student.setDepartment(newDepartment);

            return true;
        }

        return false;
    }

  public boolean deleteStudent(int id) {

    Student student = searchStudent(id);

    if (student != null) {

        students.remove(student);

        return true;
    }

    return false;
}

    public ArrayList<Student> getStudents() {
        return students;
    }
}
