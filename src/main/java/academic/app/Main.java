package academic.app;

import academic.dao.*;
import academic.db.DatabaseConnection;
import academic.model.*;
import java.sql.Connection;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    private static int readInt(Scanner scanner, String label) {
        System.out.print(label);

        return Integer.parseInt(
            scanner.nextLine().trim()
        );
    }

    public static void studentCRUD(Scanner scanner, StudentDAO sdao){
        while (true) {
                    System.out.println("\n=== STUDENT INFORMATION ===");
                    System.out.println("1. Add New Student");
                    System.out.println("2. View All Student");
                    System.out.println("3. Update Student Information");
                    System.out.println("4. Delete Student Information");
                    System.out.println("0. Exit");
                    System.out.print("Choose menu: ");

                    String choice = scanner.nextLine();

                    try {
                        switch (choice) {

                            case "1": {                 
                                System.out.print("NIM : ");
                                String studentNumber = scanner.nextLine();

                                System.out.print("Nama Lengkap : ");
                                String studentName = scanner.nextLine();

                                if (studentName.isEmpty() || studentNumber.isEmpty()) {
                                    System.out.println("Invalid student data.");
                                    break;
                                }

                                Student student = new Student(studentNumber, studentName);

                                int rows = sdao.createStudent(student);

                                System.out.println(
                                    rows == 1 ? "Student created!"
                                              : "Student not created."
                                );
                                break;
                            }

                            case "2": {
                                sdao.showAllStudents();
                                break;
                            }

                            case "3": {
                                int studentId = readInt(scanner, "Student ID: ");

                                System.out.print("NIM : ");
                                String studentNumber = scanner.nextLine();

                                System.out.print("Nama Lengkap : ");
                                String studentName = scanner.nextLine();

                                if (studentName.isEmpty() || studentNumber.isEmpty()) {
                                    System.out.println("Invalid input.");
                                    break;
                                }

                                int rows = sdao.updateStudent(studentId, studentNumber, studentName);

                                System.out.println(
                                    rows > 0 ? "Student updated!"
                                             : "Student not found or unchanged."
                                );
                                break;
                            }

                            case "4": {
                                int studentId = readInt(scanner, "Student ID: ");

                                int rows = sdao.deleteStudent(studentId);

                                System.out.println(
                                    rows > 0 ? "Student deleted!"
                                             : "student not found."
                                );

                                break;
                            }

                            case "0": {
                                System.out.println("Back to main menu...");
                                return;
                            }

                            default:
                                System.out.println("Invalid menu.");
                        }

                    } catch (NumberFormatException e) {

                    System.out.println(
                        "Input error: Please enter a valid number."
                    );

                    } catch (SQLException e) {

                        System.out.println("Database operation failed!");
                        System.out.println("Message: " + e.getMessage());
                        System.out.println("SQL State: " + e.getSQLState());
                    }
        }
    }

    public static void lecturerCRUD(Scanner scanner, LecturerDAO ldao){
        while (true) {
                    System.out.println("\n=== LECTURER INFORMATION ===");
                    System.out.println("1. Add Lecturer");
                    System.out.println("2. View All Lecturer");
                    System.out.println("3. Update Lecturer Information");
                    System.out.println("4. Delete Lecturer Information");
                    System.out.println("0. Exit");
                    System.out.print("Choose menu: ");

                    String choice = scanner.nextLine();

                    try {
                        switch (choice) {

                            case "1": {                 
                                System.out.print("NIDN : ");
                                String lecturerCode = scanner.nextLine();

                                System.out.print("Nama Lengkap : ");
                                String fullName = scanner.nextLine();

                                if (fullName.isEmpty() || lecturerCode.isEmpty()) {
                                    System.out.println("Invalid student data.");
                                    break;
                                }

                                Lecturer lecturer = new Lecturer(lecturerCode, fullName);

                                int rows = ldao.createLecturer(lecturer);

                                System.out.println(
                                    rows == 1 ? "Lecturer created!"
                                              : "Lecturer not created."
                                );
                                break;
                            }

                            case "2": {
                                ldao.showAllLecturers();
                                break;
                            }

                            case "3": {
                                int lecturerId = readInt(scanner, "Lecturer ID: ");

                                System.out.print("NIDN : ");
                                String lecturerCode = scanner.nextLine();

                                System.out.print("Nama Lengkap : ");
                                String fullName = scanner.nextLine();

                                if (fullName.isEmpty() || lecturerCode.isEmpty()) {
                                    System.out.println("Invalid lecturer data.");
                                    break;
                                }

                                int rows = ldao.updateLecturer(lecturerId, lecturerCode, fullName);

                                System.out.println(
                                    rows == 1 ? "Lecturer updated!"
                                              : "Lecturer not found or unchanged."
                                );
                                break;
                            }

                            case "4": {
                                int lecturerId = readInt(scanner, "Lecturer ID: ");

                                int rows = ldao.deleteLecturer(lecturerId);

                                System.out.println(
                                    rows > 0 ? "Lecturer deleted!"
                                             : "Lecturer not found."
                                );
                                break;
                            }

                            case "0": {
                                System.out.println("Back to main menu...");
                                return;
                            }

                            default:
                                System.out.println("Invalid menu.");
                        }

                    } catch (NumberFormatException e) {

                    System.out.println(
                        "Input error: Please enter a valid number."
                    );

                    } catch (SQLException e) {

                        System.out.println("Database operation failed!");
                        System.out.println("Message: " + e.getMessage());
                        System.out.println("SQL State: " + e.getSQLState());
                    }
        }            
    }

    public static void courseCRUD(Scanner scanner, CourseDAO cdao){
            while (true) {
                    System.out.println("\n=== COURSE INFORMATION ===");
                    System.out.println("1. Add Course");
                    System.out.println("2. View All Course");
                    System.out.println("3. Update Course");
                    System.out.println("4. Delete Course");
                    System.out.println("0. Exit");
                    System.out.print("Choose menu: ");

                    String choice = scanner.nextLine();

                    try {
                        switch (choice) {

                            case "1": {                 
                                System.out.print("Kode Matakuliah : ");
                                String courseCode = scanner.nextLine();

                                System.out.print("Nama Matakuliah : ");
                                String courseName = scanner.nextLine();

                                int lecturerId = readInt(scanner, "Lecturer ID : ");

                                if (courseName.isEmpty() || courseCode.isEmpty() || lecturerId <= 0) {
                                    System.out.println("Invalid course data.");
                                    break;
                                }

                                Course course = new Course(courseCode, courseName, lecturerId);

                                int rows = cdao.createCourse(course);

                                System.out.println(
                                    rows == 1 ? "Course created!"
                                              : "Course not created."
                                );
                                break;
                            }

                            case "2": {
                                cdao.showAllCourse();
                                break;
                            }

                            case "3": {
                                int courseId = readInt(scanner, "Course ID : ");

                                System.out.print("Kode Matakuliah : ");
                                String courseCode = scanner.nextLine();

                                System.out.print("Nama Matakuliah : ");
                                String courseName = scanner.nextLine();

                                int lecturerId = readInt(scanner, "Lecturer ID : ");

                                if (courseName.isEmpty() || courseCode.isEmpty() || lecturerId <= 0) {
                                    System.out.println("Invalid student data.");
                                    break;
                                }

                                int rows = cdao.updateCourse(courseId, courseCode, courseName, lecturerId);

                                System.out.println(
                                    rows == 1 ? "Course updated!"
                                              : "Course not found or unchanged."
                                );
                                break;
                            }

                            case "4": {
                                int courseId = readInt(scanner, "Course ID: ");

                                int rows = cdao.deleteCourse(courseId);

                                System.out.println(
                                    rows > 0 ? "Course deleted!"
                                             : "Course not found."
                                );
                                break;
                            }

                            case "0": {
                                System.out.println("Back to main menu...");
                                return;
                            }

                            default:
                                System.out.println("Invalid menu.");
                        }

                    } catch (NumberFormatException e) {

                    System.out.println(
                        "Input error: Please enter a valid number."
                    );

                    } catch (SQLException e) {

                        System.out.println("Database operation failed!");
                        System.out.println("Message: " + e.getMessage());
                        System.out.println("SQL State: " + e.getSQLState());
                    }
        }
    }

    public static void enrollmentCRUD(Scanner scanner, EnrollmentDAO edao){
        while (true) {
                    System.out.println("\n=== ENROLLMENT INFORMATION ===");
                    System.out.println("1. Enroll Student in Course");
                    System.out.println("2. View All Enrollments");
                    System.out.println("3. Update Student Grade");
                    System.out.println("4. Cancel Enrollment");
                    System.out.println("0. Exit");
                    System.out.print("Choose menu: ");

                    String choice = scanner.nextLine();

                    try {
                        switch (choice) {

                            case "1": {
                                int studentId = readInt(
                                    scanner, "Student ID : "
                                );

                                int courseId = readInt(
                                    scanner, "Course ID : "
                                );

                                System.out.print("Semester: ");
                                String semester = scanner.nextLine().trim();

                                if (studentId <= 0 || courseId <= 0
                                        || semester.isEmpty()) {
                                    System.out.println("Invalid enrollment data.");
                                    break;
                                }

                                Enrollment enrollment = new Enrollment(
                                    studentId, courseId, semester
                                );

                                int rows = edao.createEnrollment(enrollment);

                                System.out.println(
                                    rows == 1 ? "Enrollment created!"
                                              : "Enrollment not created."
                                );
                                break;     
                            }

                            case "2": {
                                edao.showAllEnrollments();
                                break;
                            }

                            case "3": {
                                int enrollmentId = readInt(
                                    scanner, "Enrollment ID : "
                                );

                                System.out.print("Grade (A-E) : ");
                                String grade = scanner.nextLine()
                                        .trim().toUpperCase();

                                if (!grade.matches("[A-E]")) {
                                    System.out.println("Invalid grade.");
                                    break;
                                }

                                int rows = edao.updateGrade(
                                    enrollmentId, grade
                                );

                                System.out.println(
                                    rows > 0 ? "Grade updated!"
                                             : "Enrollment not found or unchanged."
                                );

                                break;
                            }

                            case "4": {
                                int enrollmentId = readInt(
                                    scanner, "Enrollment ID : "
                                );

                                int rows = edao.deleteEnrollment(enrollmentId);

                                System.out.println(
                                    rows > 0 ? "Enrollment deleted!"
                                             : "Enrollment not found."
                                );

                                break;
                            }

                            case "0": {
                                System.out.println("Back to main menu...");
                                return;
                            }

                            default:
                                System.out.println("Invalid menu.");
                        }

                    } catch (NumberFormatException e) {

                        System.out.println(
                            "Input error: Please enter a valid number."
                        );

                    } catch (SQLException e) {

                        System.out.println("Database operation failed!");
                        System.out.println("Message: " + e.getMessage());
                        System.out.println("SQL State: " + e.getSQLState());
                    }
        }
    }
    
    public static void main(String[] args){
        
//                try (Connection conn =
//                DatabaseConnection.getConnection()) {
//
//            System.out.println("Database connection successful!");
//
//        } catch (SQLException e) {
//
//            System.out.println("Connection failed!");
//            System.out.println(e.getMessage());
//        }
        
        EnrollmentDAO edao = new EnrollmentDAO();
        StudentDAO sdao = new StudentDAO();
        LecturerDAO ldao = new LecturerDAO();
        CourseDAO cdao = new CourseDAO();

        try (Scanner scanner = new Scanner(System.in)) {
            while(true){
                System.out.println("\n=== CAMPUS ACADEMIC INFORMATION ===");
                System.out.println("1. Students Information");
                System.out.println("2. Lecturers Information");
                System.out.println("3. Courses Information");
                System.out.println("4. Enrollments Information");
                System.out.println("0. Exit");
                System.out.print("Choose menu: ");
                
                String choice = scanner.nextLine();
                
                try{
                    switch (choice) {
                        case "1":
                            studentCRUD(scanner, sdao);
                            break;
                        case "2":
                            lecturerCRUD(scanner, ldao);
                            break;
                        case "3":
                            courseCRUD(scanner, cdao);
                            break;
                        case "4":
                            enrollmentCRUD(scanner, edao);
                            break;
                        case "0":
                            System.out.println("Goodbye!");
                            return;
                        default:
                            System.out.println("Invalid menu.");
                    }

                } catch (NumberFormatException e) {

                    System.out.println(
                        "Input error: Please enter a valid number."
                    );
                }
            }
        }
    }
}