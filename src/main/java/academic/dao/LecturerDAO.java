package academic.dao;

import academic.db.DatabaseConnection;
import academic.model.Lecturer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author THINKPAD
 */
public class LecturerDAO {
    
    public int createLecturer(Lecturer lecturer)
        throws SQLException {
        
        String sql = "INSERT INTO lecturers (lecturer_code, full_name) "
                + "VALUES (?, ?)";
                
        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setString(1, lecturer.getLecturerCode());
            stmt.setString(2, lecturer.getFullName());
            
            return stmt.executeUpdate();
        }
    }
        
    public void showAllLecturers()
            throws SQLException{
        String sql = "SELECT lecturer_id, lecturer_code, full_name "
                + "FROM lecturers ORDER BY lecturer_id";
        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            )
        {
            boolean found = false;
            
            while(rs.next()) {
                found = true;

                System.out.println("-----------------------------");
                System.out.println("Lecturer ID     : " + rs.getInt("lecturer_id"));
                System.out.println("Lecturer Code : " + rs.getString("lecturer_code"));
                System.out.println("Full Name       : " + rs.getString("full_name"));
            }
            
            if(!found){
                System.out.println("No lecturers found");
            }
        }
    }
    public int updateLecturer(int lecturerId, String fullName)
            throws SQLException {
            String sql = "UPDATE lecturers SET full_name = ? WHERE lecturer_id = ?";
            try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
            ) {
                stmt.setString(1, fullName);
                stmt.setInt(2, lecturerId);

                return stmt.executeUpdate();
            }
        }
    
    public int deleteLecturer(int lecturerId)
            throws SQLException {
            String sql = "DELETE FROM lecturers WHERE lecturer_id = ?";
            try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
            ){
                stmt.setInt(1, lecturerId);
                
                return stmt.executeUpdate();
            }
        }
}
