/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Ahmad Mahyudi
 */
public class Teacher {
    
    int teacherId;
    String teacherName;
    String teacherIC;
    String teacherPosition;
    String teacherContact;
    

    public Teacher(int teacherId,String teacherName, String teacherIC, String teacherPosition, String teacherContact) {
        this.teacherId=teacherId;
        this.teacherIC = teacherIC;
        this.teacherName = teacherName;
        this.teacherPosition = teacherPosition;
        this.teacherContact = teacherContact;
    }

    public int getTeacherId() {
        return teacherId;
    }
    public String getTeacherIC() {
        return teacherIC;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getTeacherPosition() {
        return teacherPosition;
    }

    public String getTeacherContact() {
        return teacherContact;
    }
    
    
    
    
    
}
