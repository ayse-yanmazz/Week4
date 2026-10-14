import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("How many courses do you want to create (at least 3)? ");
        int numCourses = scanner.nextInt();
        scanner.nextLine();

        while (numCourses < 3) {
            System.out.print("Please enter at least 3 courses: ");
            numCourses = scanner.nextInt();
            scanner.nextLine();
        }

        Course[] courses = new Course[numCourses]; 

        for (int i = 0; i < numCourses; i++) {
            System.out.println("\n--- Entering details for Course " + (i + 1) + " ---");
            System.out.print("Enter course name: ");
            String courseName = scanner.nextLine();

            System.out.print("Enter classroom capacity: ");
            int capacity = scanner.nextInt();
            scanner.nextLine();

            courses[i] = new Course(courseName, capacity);
        }

        System.out.println("\n=== Available Courses for Registration ===");
        for (int i = 0; i < courses.length; i++) {
            System.out.println("- " + courses[i].getCourseName() + " (Capacity: " + courses[i].getCapacity() + ")");
        }


        boolean keepRegistering = true;
        while (keepRegistering) {
            System.out.println("\n=== Student Registration ===");
            System.out.print("Enter student ID: ");
            String studentID = scanner.nextLine();

            System.out.print("Enter student name: ");
            String name = scanner.nextLine();

            System.out.print("Enter the exact name of the course to register: ");
            String targetCourseName = scanner.nextLine();

            Course selectedCourse = null;
            for (int i = 0; i < courses.length; i++) {
                if (courses[i].getCourseName().equalsIgnoreCase(targetCourseName)) {
                    selectedCourse = courses[i];
                    break;
                }
            }

            if (selectedCourse == null) {
                System.out.println("No course found with that name.");
            } else if (selectedCourse.getStudentCount() >= selectedCourse.getCapacity()) {
                System.out.println("This course is full. Registration failed.");
            } else {
                boolean alreadyRegistered = false;
                Student[] enrolled = selectedCourse.getEnrolledStudents();

                for (int i = 0; i < selectedCourse.getStudentCount(); i++) {
                    if (enrolled[i].getStudentID().equals(studentID)) {
                        alreadyRegistered = true;
                        break;
                    }
                }

                if (alreadyRegistered) {
                    System.out.println("This student is already registered for this course.");
                } else {
                    Student newStudent = new Student(studentID, name);
                    selectedCourse.addStudent(newStudent);
                    System.out.println("Registration successful.");
                }
            }

            System.out.print("\nDo you want to register another student? (yes/no): ");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("yes")) {
                keepRegistering = false;
            }
        }


        System.out.println("\n=== Final List of All Courses and Enrolled Students ===");
        for (int i = 0; i < courses.length; i++) {
            courses[i].displayCourseInfo();
        }

        scanner.close();
    }
}
