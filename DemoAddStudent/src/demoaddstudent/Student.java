/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoaddstudent;

/**
 *
 * @author Ngo Van Tuan
 */
public class Student {
    private String name;
    private String birthday;
    private String rollNumber;
    private int gender;

    public Student() {
    }

    public Student(String name, String birthday, String rollNumber, int gender) {
        this.name = name;
        this.birthday = birthday;
        this.rollNumber = rollNumber;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}
