public class Student {

    protected int id;
    protected String name;
    protected String department;

    public Student(int id, String name, String department) {

        this.id = id;
        this.name = name;
        this.department = department;
    }

   
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void display() {

        System.out.println("\n===== STUDENT INFO =====");
        System.out.println("ID         : " + id);
        System.out.println("Name       : " + name);
        System.out.println("Department : " + department);
    }
}
