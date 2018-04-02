/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siinblog.bank;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Ngo Van Tuan
 */
public class AccountController {
    AccountModel mod = new AccountModel();
    private String username;
    public String getHomePage(){
        System.out.println("1. Đăng Nhập");
        System.out.println("2. Đăng Ký");
        Scanner sc = new Scanner(System.in);
        String pick = sc.nextLine();
        return pick;
    }
    
    public boolean getLogin() throws SQLException{
        Scanner sc = new Scanner(System.in);
        System.out.print("Tài Khoản: ");
        this.username = sc.nextLine();
        System.out.print("Mật Khẩu: ");
        String password = sc.nextLine();
        boolean check = mod.checkLogin(username, password);
        return check;
    }
    
    public Account register() throws SQLException{
        Scanner sc = new Scanner(System.in);
        System.out.print("Tài Khoản: ");
        String username = sc.nextLine();
        System.out.print("Mật Khẩu: ");
        String password = sc.nextLine();
        Account acc = new Account(username, password);
        mod.addMember(acc);
        return acc;
    }
    public String getMenu(){
        System.out.println("1. Kiểm tra số dư");
        System.out.println("2. Rút tiền");
        System.out.println("3. Gửi tiền");
        Scanner sc = new Scanner(System.in);
        String pick = sc.nextLine();
        return pick;
    }
    
    public boolean getInfo() throws SQLException{
        mod.getAccount(this.username);
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
        return true ;
    }
    
    public void getMoney() throws SQLException{
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số tiền bạn muốn rút: ");
        int money = scanner.nextInt();
        if (money == 0) {
            System.out.println("Số tiền cần rút phải lớn hơn 0");
        } else if (money <= 50000){
            System.out.println("Số tiền cần rút phải lớn hơn 50k");
        } else {
            if (mod.getMon(username, money)) {
                System.out.println("Thành công!\nBạn vui lòng nhận tiền và nhận lại thẻ!");
                String scan = scanner.nextLine();
            }
            else{
                System.out.println("Số dư không đủ");
                return;
            }
        }
    }
    
    public void addMoney() throws SQLException{
        Scanner scanner = new Scanner(System.in);
        System.out.print("Số tiền bạn muốn gửi là: ");
        int money = scanner.nextInt();
        if (money == 0) {
            System.out.println("Số tiền gửi không thể bằng 0");
        } else if (money <= 50000){
            System.out.println("Số tiền gửi phải lớn hơn 50k");
        } else {
            if (mod.addMon(username, money)) {
                System.out.println("Tài khoản của bạn có thêm " + money + "VNĐ");
                String scan = scanner.nextLine();
            }
            else{
                System.out.println("Oops! Có lỗi xảy ra.");
                return;
            }
        }
    }
}
