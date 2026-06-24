public class RegularStudent extends Student {

    public RegularStudent(
            int id,
            String name,
            String department) {

        super(id, name, department);
    }

    @Override
    public void display() {

        System.out.println("\n--- REGULAR STUDENT ---");

        super.display();
    }
}
