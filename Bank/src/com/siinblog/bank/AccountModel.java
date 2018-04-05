/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.siinblog.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
*
* @author Ngo Van Tuan
*/
public class AccountModel {
    public boolean checkLogin(String username, String password) throws SQLException {
        Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/account?useUnicode=true"
                + "&characterEncoding=UTF-8","root","");
        Statement stt = cnn.createStatement();
        ResultSet rs = stt.executeQuery("SELECT * FROM accounts WHERE username = '" + username + "' "
                + "AND password = '" + password + "'");
        if (rs.next()) {
            return true;
        }
        else{
            System.out.println("Oops! Có lỗi xảy ra.");
            return false;
        }
    }
    
    public void addMember(Account account) throws SQLException {
        Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/account?useUnicode=true"
                        + "&characterEncoding=UTF-8","root","");
        Statement stt = cnn.createStatement();
        ResultSet rs = stt.executeQuery("SELECT * FROM accounts WHERE username = '" + account.getUsername() + "'");
        if (rs.next()) {
            System.out.println("Tài khoản đã tồn tại!");
        } else {
            String sql = "insert into accounts (username, password) values (?, ?)";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, account.getUsername());
            ps.setString(2, account.getPassword());
            ps.execute();
            if (true) {
                System.out.println("Đăng ký thành công.");
                System.out.println("Tài khoản: " + account.getUsername());
                System.out.println("Mật khẩu: " + account.getPassword());
                System.out.println("\n-------------------------------------\n");
            } else {
                System.out.println("Oops! Có lỗi xảy ra.");
            }
        }
    }
    
    public void getAccount(String username) throws SQLException{
        Connection cnn = 
                DriverManager.getConnection("jdbc:mysql://localhost:3306/account?useUnicode=true"
                        + "&characterEncoding=UTF-8","root","");
        Statement stt = cnn.createStatement();
        ResultSet rs = stt.executeQuery("SELECT * FROM accounts WHERE username = '" + username + "'");
        while (rs.next()) {
            System.out.println(" ---------------- ");
            System.out.println("Số Tài Khoản: " + rs.getInt("accountNumber"));
            System.out.println("Tài Khoản: " + rs.getString("username"));
            System.out.println("Số Dư: " + rs.getInt("balance") + "VND");
        }
    }
    
    public boolean getMon(String username, int mon) throws SQLException{
        Connection cnn = 
                DriverManager.getConnection("jdbc:mysql://localhost:3306/account?useUnicode=true&characterEncoding=UTF-8","root","");
        Statement stt = cnn.createStatement();
        ResultSet rs = stt.executeQuery("SELECT * FROM accounts WHERE username = '" + username + "'");
        int balance = 0;
        while (rs.next()) {
            balance = rs.getInt("balance");
            if (balance < mon) {
                return false;
            }
            else{
                balance -= mon;
            }
            stt.execute("UPDATE accounts SET balance = " + balance + " "
                    + "WHERE username = '" + username + "'");
            return true;
        }
        return false;
    }
    
    public boolean addMon(String username, int mon) throws SQLException{
        Connection cnn = 
                DriverManager.getConnection("jdbc:mysql://localhost:3306/account?useUnicode=true"
                        + "&characterEncoding=UTF-8","root","");
        Statement stt = cnn.createStatement();
        ResultSet rs = stt.executeQuery("SELECT * FROM accounts WHERE username = '" + username + "'");
        int balance = 0;
        while (rs.next()) {
            balance = rs.getInt("balance");
            balance += mon;
            stt.execute("UPDATE accounts SET balance = " + balance + " "
                    + "WHERE username = '" + username + "'");
            return true;
        }
        return false;
    }
}
