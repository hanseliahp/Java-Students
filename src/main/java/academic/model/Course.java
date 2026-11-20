/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academic.model;

/**
 *
 * @author THINKPAD
 */
public class Course {
    private int courseId;
    private String courseCode;
    private String courseName;
    private int lecturerId;
    
    public Course(String courseCode, String courseName, int lecturerId){
        this.courseCode= courseCode;
        this.courseName = courseName;
        this.lecturerId = lecturerId;
    }
    
    public Course(int courseId, String courseCode, String courseName, int lecturerId){
        this.courseId = courseId;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.lecturerId = lecturerId;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getLecturerId() {
        return lecturerId;
    }
    
}
