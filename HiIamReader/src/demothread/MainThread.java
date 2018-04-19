/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demothread;

/**
 *
 * @author Ngo Van Tuan
 */
public class MainThread extends Thread {
    public static void main(String[] args) {
        FirstThread s1 = new FirstThread();
        SecondThread s2 = new SecondThread();
        s1.start();
        s2.start();
    }
}
