/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoaddstudent;

/**
 *
 * @author Ngo Van Tuan
 */
public class DemoAddStudent {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Controller ctrl = new Controller();
        while (true) {
            boolean siin = true;
            switch (ctrl.getMenu()) {
                case 1:
                    ctrl.addSV();
                    break;
                case 2:
                    ctrl.getSv();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("!!!!!!!!!!!!!");
            }
        }
    }
    
}
