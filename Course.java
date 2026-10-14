public class Course {
    private String courseName;
    private int capacity;
    private Student[] enrolledStudents; 
    private int studentCount;

    public Course(String courseName, int capacity) {
        this.courseName = courseName;
        this.capacity = capacity;
        this.enrolledStudents = new Student[capacity];
        this.studentCount = 0;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public Student[] getEnrolledStudents() {
        return enrolledStudents;
    }

    public void addStudent(Student student) {
        if (studentCount < capacity) {
            enrolledStudents[studentCount] = student;
            studentCount++;
        }
    }

    public void displayCourseInfo() {
        System.out.println("----------------------------------------");
        System.out.println("Course Name: " + courseName);
        System.out.println("Capacity: " + capacity);
        System.out.println("Enrolled Students Count: " + studentCount);
        System.out.println("Enrolled Students:");

        if (studentCount == 0) {
            System.out.println("  (No students enrolled yet)");
        } else {
            for (int i = 0; i < studentCount; i++) {
                System.out.println("  - " + enrolledStudents[i].getName() + " (ID: " + enrolledStudents[i].getStudentID() + ")");
            }
        }
    }
}