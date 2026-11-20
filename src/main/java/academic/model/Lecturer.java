/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academic.model;

/**
 *
 * @author THINKPAD
 */
public class Lecturer {
    private int lecturerId;
    private String lecturerNumber;
    private String fullName;
    private String email;
    
    public Lecturer(String lecturerNumber, String fullName, String email){
        this.lecturerNumber = lecturerNumber;
        this.fullName = fullName;
        this.email = email;
    }
    
    public Lecturer(int lecturerId, String lecturerNumber, String fullName, String email){
        this.lecturerId = lecturerId;
        this.lecturerNumber = lecturerNumber;
        this.fullName = fullName;
        this.email = email;
    }

    public int getLecturerId() {
        return lecturerId;
    }

    public String getLecturerNumber() {
        return lecturerNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }
    
}
