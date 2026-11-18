/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academic.model;

/**
 *
 * @author THINKPAD
 */
public class Enrollment {
    
    private int studentId;
    private int courseId;
    private String semester;

    public Enrollment(
            int studentId,
            int courseId,
            String semester) {

        this.studentId = studentId;
        this.courseId = courseId;
        this.semester = semester;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getSemester() {
        return semester;
    }
}
