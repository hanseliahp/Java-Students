/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academic.model;

/**
 *
 * @author ACER
 */
public class Student {
    
    private int studentId;
    private String studentNumber;
    private String studentName;
    
    public Student(String studentNumber, String studentName){
        this.studentNumber = studentNumber; 
        this.studentName = studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getStudentName() {
        return studentName;
    }
}