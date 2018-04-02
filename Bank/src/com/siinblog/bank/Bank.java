/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siinblog.bank;

import java.sql.SQLException;

/**
 *
 * @author Ngo Van Tuan
 */
public class Bank {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        AccountController ctrl = new AccountController();
        AccountModel model = new AccountModel();
        while (true) {     
            boolean menu = true;
            switch(ctrl.getHomePage()){
                case "1":
                    if (ctrl.getLogin()) {
                        while (menu) {                            
                            switch(ctrl.getMenu()){
                                case "1":
                                    ctrl.getInfo();
                                    break;
                                case "2":
                                    ctrl.getMoney();
                                    break;
                                case "3":
                                    ctrl.addMoney();
                                    break;
                                default:
                                    menu = false;
                                    break;
                            }
                        }
                    }
                    break;
                case "2":
                    Account acc = ctrl.register();
                    break;
                default:
                    System.out.println("Oops! Có lỗi xảy ra.");
                    break;
            }
        }
    }
    
}
