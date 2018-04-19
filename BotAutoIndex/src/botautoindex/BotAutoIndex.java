/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botautoindex;

import controller.BotController;
import model.BotModel;

/**
 *
 * @author Ngo Van Tuan
 */
public class BotAutoIndex {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        BotController ctrl = new BotController();
        BotModel bm = new BotModel();
        bm.getIndex();
    }
    
}
