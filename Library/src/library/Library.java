/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.IOException;

/**
 *
 * @author Ngo Van Tuan
 */
public class Library {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Controller ctrl = new Controller();
        while(true) {
            boolean siin = true;
            switch(ctrl.getHome()) {
                case 1:
                    ctrl.addAuthor();
                    break;
                case 2:
                    ctrl.addPC();
                    break;
                case 3:
                    ctrl.addBook();
                    break;
                case 4:
                    ctrl.infoAuthor();
                    break;
                case 5:
                    
                    break;
                case 6:
                    ctrl.infoBook();
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    return;
            }
        }
    }
    
}
