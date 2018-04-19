/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siinapplication;

/**
 *
 * @author Ngo Van Tuan
 */
public class Account {
    private int id;
    private String password;
    private int balance;
    
    public boolean withdraw(int amount) {
        if (this.balance < amount) {
            System.err.println("Ban deo du tien :)");
            return false;
        }
        this.balance -= amount;
        return true;
    }
    
    public void deposit(int total) {
        this.balance += total;
    }

    public Account() {
    }

    public Account(int id, String password, int balance) {
        this.id = id;
        this.password = password;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    
    
}
