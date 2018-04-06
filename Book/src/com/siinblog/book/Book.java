/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siinblog.book;

/**
 *
 * @author Ngo Van Tuan
 */
public class Book {
    private int ID;
    private String name;
    private String author;
    private String NXB;

    public Book() {
    }

    public Book(int ID, String name, String author, String NXB) {
        this.ID = ID;
        this.name = name;
        this.author = author;
        this.NXB = NXB;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getNXB() {
        return NXB;
    }

    public void setNXB(String NXB) {
        this.NXB = NXB;
    }

    @Override
    public String toString() {
        return "Book{" + "ID=" + ID + ", name=" + name + ", author=" + author + ", NXB=" + NXB + '}';
    }
}
