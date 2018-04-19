/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;

/**
 *
 * @author Ngo Van Tuan
 */
public class Bot {
    private int ID;
    private String name;
    private String url;
    private int status;

    public Bot() {
    }

    public Bot(String name, String url) {
        this.name = name;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        int hashMultiplikator = 79;
        hash = hashMultiplikator * hash + this.url.hashCode();
        return hash;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Bot) {
            Bot bot = (Bot) obj;
            if (this.url.equals(bot.url)) {
                return true;
            }
        }
        return false;
    }
}