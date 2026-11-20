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
    
    public Lecturer(String lecturerNumber, String fullName){
        this.lecturerNumber = lecturerNumber;
        this.fullName = fullName;
    }
    
    public Lecturer(int lecturerId, String lecturerNumber, String fullName){
        this.lecturerId = lecturerId;
        this.lecturerNumber = lecturerNumber;
        this.fullName = fullName;
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

}
