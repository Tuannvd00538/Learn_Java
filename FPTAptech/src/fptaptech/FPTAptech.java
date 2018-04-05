/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fptaptech;

/**
 *
 * @author Ngo Van Tuan
 */
public class FPTAptech {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EventController ctrl = new EventController();
        EventModel em = new EventModel();
        while (true) {
            boolean option = true;
            switch (ctrl.getHome()) {
                case "1":
                    while (option) {
                        Event event = ctrl.add();
                        break;
                    }
                    break;
                case "2":
                    while (option) {
                        em.getList();
                        break;
                    }
                    break;
                case "3":
                    while (option) {
                        ctrl.find();
                        break;
                    }
                    break;
                case "4":
                    return;
            }
        }
    }
    
}
