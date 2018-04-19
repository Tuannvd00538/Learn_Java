/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.Serializable;

/**
 *
 * @author Ngo Van Tuan
 */
public class Book implements Serializable {
    private String name;
    private String kindofbook;
    private String author;
    private int publishingyear;
    private String publishingcompany;

    public Book() {
    }

    public Book(String name, String kindofbook, String author, int publishingyear, String publishingcompany) {
        this.name = name;
        this.kindofbook = kindofbook;
        this.author = author;
        this.publishingyear = publishingyear;
        this.publishingcompany = publishingcompany;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKindofbook() {
        return kindofbook;
    }

    public void setKindofbook(String kindofbook) {
        this.kindofbook = kindofbook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishingyear() {
        return publishingyear;
    }

    public void setPublishingyear(int publishingyear) {
        this.publishingyear = publishingyear;
    }

    public String getPublishingcompany() {
        return publishingcompany;
    }

    public void setPublishingcompany(String publishingcompany) {
        this.publishingcompany = publishingcompany;
    }
}
