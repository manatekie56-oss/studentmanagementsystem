import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        School school = new School();
        StudentDAO dao = new StudentDAO();

        int choice;

        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Register Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Save Student To Database");
            System.out.println("7. Display Database Students");
            System.out.println("8. Exit");
            System.out.print("Choice: ");

            while (!input.hasNextInt()) {
                System.out.println("❌ Please enter a number.");
                input.next();
                System.out.print("Choice: ");
            }

            choice = input.nextInt();
            input.nextLine(); // Clear the buffer

            switch (choice) {

                case 1:
                    System.out.print("Enter Student ID: ");
                    String idInput = input.nextLine();

                    while (!idInput.matches("\\d+")) {
                        System.out.println("❌ ID must be numeric.");
                        System.out.print("Enter Student ID: ");
                        idInput = input.nextLine();
                    }

                    int id = Integer.parseInt(idInput);

                    System.out.print("Enter Student Name: ");
                    String name = input.nextLine();

                    while (!name.matches("[a-zA-Z ]+")) {
                        System.out.println("❌ Name must contain letters only.");
                        System.out.print("Enter Student Name: ");
                        name = input.nextLine();
                    }

                    System.out.print("Enter Department: ");
                    String department = input.nextLine();

                    Student student = new RegularStudent(id, name, department);
                    school.addStudent(student);
                    System.out.println("✅ Student registered successfully!");
                    break;

                case 2:
                    school.displayStudents();
                    break;

                case 3:
                    System.out.print("Enter Student ID to Search: ");
                    int searchId = input.nextInt();
                    input.nextLine();

                    Student found = school.searchStudent(searchId);
                    if (found != null) {
                        System.out.println("\n✅ Student Found:");
                        found.display();
                    } else {
                        System.out.println("\n❌ Student Not Found.");
                    }
                    break;

                case 4:

                    System.out.print("Enter Student ID to Update: ");
                    int updateId = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = input.nextLine();

                    System.out.print("Enter New Department: ");
                    String newDepartment = input.nextLine();

                    if (school.updateStudent(
                            updateId,
                            newName,
                            newDepartment)) {

                        System.out.println(
                                "✅ Student Updated Successfully!");

                    } else {

                        System.out.println(
                                "❌ Student Not Found!");
                    }

                    break;

                case 5:

                    System.out.print("Enter Student ID to Delete: ");
                    int deleteId = input.nextInt();
                    input.nextLine();

                    if (school.deleteStudent(deleteId)) {

                        System.out.println(" Student Deleted Successfully!");

                    } else {

                        System.out.println(" Student Not Found!");
                    }

                    break;

                case 6:
                    System.out.println("💾 Saving students to database via DAO...");
                    break;

                case 7:
                    System.out.println("📊 Fetching database records...");
                    break;

                case 8:
                    System.out.println("\n👋 Goodbye!");
                    break;

                default:
                    System.out.println("\n❌ Invalid Choice. Please select 1-8.");
            }

        } while (choice != 8); // Loop continues until user explicitly inputs 8

        input.close();
    }
}
