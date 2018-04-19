/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package again.reflection;

import myannotation.AutoGenerate;
import myannotation.MyId;

/**
 *
 * @author Ngo Van Tuan
 */
public class Student {
    @MyId
    @AutoGenerate
    private int id;
    private String name;
    private String rollNumber;

    public Student() {
    }

    public Student(String name, String rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }
    
    
}
