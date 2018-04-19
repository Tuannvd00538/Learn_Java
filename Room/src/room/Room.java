/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package room;

/**
 *
 * @author Ngo Van Tuan
 */
public class Room {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ban ban = new Ban(15, "Trang");
        Ghe ghe = new Ghe(30, "Cam");
        MayChieu mc = new MayChieu(1, "Trang");
        Quat quat = new Quat(2, "Trang");
        
        System.out.println("So ban la " + ban.getSoluong() + " co mau "  + ban.getMausac() +  " - so ghe la " + ghe.getSoluong() + " co mau " + ghe.getMausac() + " - so may chieu la " + mc.getSoluong() + " co mau " + mc.getMausac() + " - so quat la " + quat.getSoluong() + " co mau "  + quat.getMausac());
    }   
}