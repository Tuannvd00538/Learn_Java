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
public class SiinApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        Account acc = new Account(0, "siin", 5000);
        
        WithdrawThread ruttien1 = new WithdrawThread(acc, 6000);
        WithdrawThread ruttien2 = new WithdrawThread(acc, 60000);
        WithdrawThread ruttien3 = new WithdrawThread(acc, 600000);
        DepositThread guitien1 = new DepositThread(acc, 5000);
//        DepositThread guitien2 = new DepositThread(acc, 25000);
//        DepositThread guitien3 = new DepositThread(acc, 35000);
        
        ruttien1.start();
        ruttien2.start();
        ruttien3.start();
        guitien1.start();
//        guitien2.start();
//        guitien3.start();
        ruttien1.join();
        ruttien2.join();
        ruttien3.join();
        guitien1.join();
//        guitien2.join();
//        guitien3.join();
        System.out.println("Last balance: " + acc.getBalance());
    }
    
}
