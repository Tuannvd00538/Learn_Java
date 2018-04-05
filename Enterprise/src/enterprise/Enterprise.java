/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enterprise;

import java.sql.SQLException;

/**
 *
 * @author Ngo Van Tuan
 */
public class Enterprise  {
    public static void main(String[] args) throws SQLException {
        ControllerEnterprise ctrl = new ControllerEnterprise();
        ModelEnterprise me = new ModelEnterprise();
        while (true) {
            boolean option = true;
            switch (ctrl.getMenu()) {
                case "1":
                    while (option) {
                        EntityEnterprise enterprise = ctrl.add();
                        break;
                    }
                    break;
                case "2":
                    while (option) {
                        switch (ctrl.getEnterPrise()) {
                            case "1":
                                me.getAction();
                                break;
                            case "2":
                                me.getNonAction();
                                break;
                            case "3":
                                option = false;
                                break;
                        }
                    }
                    break;
                case "3":
                    while (option) {
                        me.find();
                        break;
                    }
                    break;
                case "4":
                    return;
            }
        }
    }
}
