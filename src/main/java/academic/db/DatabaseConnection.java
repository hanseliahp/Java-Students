/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academic.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author THINKPAD
 */
public class DatabaseConnection {
    private static final String URL =
            "jdbc:mariadb://localhost:3306/campus_academic";

    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection()
            throws SQLException {

        return DriverManager.getConnection(
                URL, USER, PASSWORD
        );
    }
}
