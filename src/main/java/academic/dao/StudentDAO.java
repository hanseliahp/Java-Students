/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academic.dao;

import academic.db.DatabaseConnection;
import academic.model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ACER
 */
public class StudentDAO {
    
    public int createStudent(Student student)
            throws SQLException {

        String sql = 
                "INSERT INTO students(student_number, full_name) "
                + "VALUES (?, ?)";

        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setString(1, student.getStudentNumber());
            stmt.setString(2, student.getStudentName());

            return stmt.executeUpdate();
        }
    }
    
    public void showAllStudents() throws SQLException{
        
        String sql = "SELECT `student_id`, `student_number`, `full_name` FROM `students`";
        
        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()
        ) {
            boolean found = false;

            while (rs.next()) {
                found = true;

                System.out.println("------------------------------------------------------");
                System.out.println("Student ID      : " + rs.getInt("student_id"));
                System.out.println("Student Number  : " + rs.getString("student_number"));
                System.out.println("Student Name    : " + rs.getString("full_name"));
            }
            
            if (!found){
                System.out.println("No students found.");
            }   
        }
    }
    
    public int updateStudent(int studentId, String studentNumber, String studentName)
            throws SQLException {

        String sql = 
                "UPDATE students SET student_number = ?, full_name = ? "
                + "WHERE student_id = ?";

        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setString(1, studentNumber);
            stmt.setString(2, studentName);
            stmt.setInt(3, studentId);

            return stmt.executeUpdate();
        }
    }
    
    public int deleteStudent(int studentId) throws SQLException {
        String sql =
            "DELETE FROM students WHERE student_id = ?";

        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setInt(1, studentId);

            return stmt.executeUpdate();
        }
    }  
}
