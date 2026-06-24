public class ScholarshipStudent extends Student {

    private double scholarshipAmount;

    public ScholarshipStudent(
            int id,
            String name,
            String department,
            double scholarshipAmount) {

        super(id, name, department);

        this.scholarshipAmount =
                scholarshipAmount;
    }

    @Override
    public void display() {

        System.out.println(
                "\n--- SCHOLARSHIP STUDENT ---");

        super.display();

        System.out.println(
                "Scholarship : $"
                        + scholarshipAmount);
    }
}
