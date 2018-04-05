/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fptaptech;

/**
 *
 * @author Ngo Van Tuan
 */
public class Event {
    private int id;
    private String name;
    private String createAt;
    private String endAt;
    private int category;
    private int status;

    public Event() {
    }

    public Event(String name, String createAt, String endAt, int category) {
        this.name = name;
        this.createAt = createAt;
        this.endAt = endAt;
        this.category = category;
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

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getEndAt() {
        return endAt;
    }

    public void setEndAt(String endAt) {
        this.endAt = endAt;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    public String getCategoryName(int category){
        return category == 1 ? "Team building" : "Hội thảo";
    }
}
