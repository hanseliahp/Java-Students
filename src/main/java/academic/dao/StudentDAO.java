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
                "INSERT INTO `students`(`student_number`, `full_name`) "
                + "VALUES ('" + student.getStudentNumber() + "','" + student.getStudentName() + "')";

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
}
