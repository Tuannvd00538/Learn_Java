/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botthread;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import model.BotModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Ngo Van Tuan
 */
public class BotThreadDelay extends Thread {

    @Override
    public void run() {
        BotModel bm = new BotModel();
        try {
            Thread.sleep(15000);
            bm.botDelay();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
