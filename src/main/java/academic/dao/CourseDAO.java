package academic.dao;

import academic.db.DatabaseConnection;
import academic.model.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author THINKPAD
 */
public class CourseDAO {
    
    public int createCourse(Course course)
            throws SQLException{
        String sql = "INSERT INTO courses (course_code, course_name, lecturer_id) VALUES (?, ?, ?)";
    try (
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
    ) {
        stmt.setString(1, course.getCourseCode());
        stmt.setString(2, course.getCourseName());
        stmt.setInt(3, course.getLecturerId());
        
        return stmt.executeUpdate();
    }
    } 
    
    public void showAllCourse()
            throws SQLException {
        String sql = 
                "SELECT c.course_id, c.course_code, c.course_name, "
                + "l.full_name AS lecturer_name FROM courses c JOIN lecturers l ON "
                + "c.lecturer_id = l.lecturer_id ORDER BY c.course_id";
    try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
        ) {
            boolean found = false;
            
            while(rs.next()) {
                found = true;
               
                System.out.println("-----------------------------");
                System.out.println("Course ID       : " + rs.getInt("course_id"));
                System.out.println("Course Number   : " + rs.getString("course_code"));
                System.out.println("Course Name     : " + rs.getString("course_name"));
                System.out.println("Lecturer        : " + rs.getString("lecturer_name"));
            }
            
            if(!found){
                System.out.println("No courses found");
            }
        }
    }
    
    public int updateCourse(int courseId, String courseName, int lecturerId)
            throws SQLException {
        
        String sql = "UPDATE courses SET course_name = ?, "
                + "lecturer_id = ? WHERE course_id = ?";
    try (
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
    ){
        stmt.setString(1, courseName);
        stmt.setInt(2, lecturerId);
        stmt.setInt(3, courseId);
        
        return stmt.executeUpdate();
    }
    }
    
    public int deleteCourse(int courseId)
            throws SQLException {
        String sql = "DELETE FROM courses WHERE course_id = ?";
    try (
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
    ) {
        stmt.setInt(1, courseId);
        
        return stmt.executeUpdate();
    }
    }
}
