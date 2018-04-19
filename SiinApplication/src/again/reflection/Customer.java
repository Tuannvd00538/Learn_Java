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
public class Customer {
    @MyId
    @AutoGenerate
    private int id;
    private String fullName;

    public Customer() {
    }

    public Customer(String fullName) {
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    
}
