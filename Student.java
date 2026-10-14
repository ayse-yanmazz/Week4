public class Student {
    private String studentID;
    private String name;

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public void printStudentInfo() {
        System.out.println("ID: " + studentID + ", Name: " + name);
    }  
}
