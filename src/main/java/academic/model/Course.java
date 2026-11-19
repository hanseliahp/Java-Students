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
    private String courseNumber;
    private String courseName;
    private int credits;
    private int lecturerId;
    
    public Course(String courseNumber, String courseName, int credits, int lecturerID){
        this.courseNumber = courseNumber;
        this.courseName = courseName;
        this.credits = credits;
        this.lecturerId = lecturerId;
    }
    
    public Course(int courseId, String courseNumber, String courseName, int credits, int lecturerID){
        this.courseId = courseId;
        this.courseNumber = courseNumber;
        this.courseName = courseName;
        this.credits = credits;
        this.lecturerId = lecturerId;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }

    public int getLecturerId() {
        return lecturerId;
    }
    
}
