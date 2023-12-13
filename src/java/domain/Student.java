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
public class Student {
    int studId;
    String studName;
    String studIC;
    int studAge;
    String studGender;
    String studBirthCercitificate;

    public Student(int studId, String studName, String studIC, int studAge, String studGender, String studBirthCercitificate) {
        this.studId = studId;
        this.studName = studName;
        this.studIC = studIC;
        this.studAge = studAge;
        this.studGender = studGender;
        this.studBirthCercitificate = studBirthCercitificate;
    }

    public int getStudId() {
        return studId;
    }

    public String getStudName() {
        return studName;
    }

    public String getStudIC() {
        return studIC;
    }

    public int getStudAge() {
        return studAge;
    }

    public String getStudGender() {
        return studGender;
    }

    public String getStudBirthCercitificate() {
        return studBirthCercitificate;
    }
    
    
    
}
