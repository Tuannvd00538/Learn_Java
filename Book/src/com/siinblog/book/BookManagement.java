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
public class BookManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Book book = new Book();
        Controller ctrl = new Controller();
        while (true) {
            boolean option = true;
            switch(ctrl.getHomePage()){
                case "1" :
                    boolean option1 = true;
                    while (option1) {
                        switch(ctrl.getList()){
                            case 0:
                                option1 = false;
                                break;
                            default:
                                boolean option2 = true;
                                while (option2) {
                                    switch(ctrl.getDetail()){
                                        case "1":
                                            boolean option3 = true;
                                            while (option3) {
                                                switch (ctrl.edit()) {
                                                    case "1":
                                                        ctrl.editName();
                                                        option3 = false;
                                                        break;
                                                    case "2":
                                                        ctrl.editAuthor();
                                                        option3 = false;
                                                        break;
                                                    case "3":
                                                        ctrl.editNXB();
                                                        option3 = false;
                                                        break;
                                                    case "4":
                                                        option3 = false;
                                                        break;
                                                }
                                            }
                                            break;
                                        case "2":
                                            boolean option4 = true;
                                            while (option4) {
                                                switch (ctrl.remove()) {
                                                    case "1":
                                                        ctrl.removeBook();
                                                        option4 = false;
                                                        break;
                                                    case "2":
                                                        option4 = false;
                                                        break;
                                                }
                                            }
                                            option2 = false;
                                            break;
                                        default:
                                            option2 = false;
                                            break;
                                    }
                                }
                                break;
                        }
                    }
                    break;
                case "2" :
                    while (option) {
                        switch (ctrl.search()) {
                            case "1":
                                ctrl.findByName();
                                break;
                            case "2":
                                ctrl.findByAuthor();
                                break;
                            case "3":
                                ctrl.findByNXB();
                                break;
                            case "4":
                                option = false;
                                break;
                        }
                    }
                    break;
                case "3":
                    ctrl.addBook();
                    break;
                case "4":
                    return;
                default:
                    option = false;
                    break;
            }
        }
    }
}