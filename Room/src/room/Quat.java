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
public class Quat {
    private int soluong;
    private String mausac;

    public Quat() {
    }

    public Quat(int soluong, String mausac) {
        this.soluong = soluong;
        this.mausac = mausac;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getMausac() {
        return mausac;
    }

    public void setMausac(String mausac) {
        this.mausac = mausac;
    }
}
