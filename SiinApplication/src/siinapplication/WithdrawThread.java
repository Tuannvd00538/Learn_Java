/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siinapplication;

/**
 *
 * @author Ngo Van Tuan
 */
public class WithdrawThread extends Thread {
    private Account account;
    private int amount;
    
    public WithdrawThread(Account account, int amount) {
        this.account = account;
        this.amount = amount;
    }
    
    @Override
    public void run() {
        synchronized (this.account) {
            System.out.println(Thread.currentThread().getName() + " - before " + this.account.getBalance());
            try {
                Thread.sleep(2 * 1000);
                while (!this.account.withdraw(this.amount)) {
                    wait();
                    System.out.println(Thread.currentThread().getName() + " is waiting...");
                }
            } catch (Exception e) {
                System.err.println(e);
            }
            System.out.println("-------------------");
        }
    }
}
