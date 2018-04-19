/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import botthread.BotThread;
import controller.BotController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Ngo Van Tuan
 */
public class BotModel {
    
    public void getIndex () {
        BotController ctrl = new BotController();
        try {
            Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bot?useUnicode=true"
                        + "&characterEncoding=UTF-8","root","");
            Statement stt = cnn.createStatement();
            ResultSet rs = stt.executeQuery("SELECT * FROM articles WHERE status = 1");
            if (rs.next()) {
                while (rs.next()) {
                    System.out.println(" - " + rs.getString("title"));
                }
            } else {
                ctrl.getLink();
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    public void getUrl(String url, String title) {
        try {
            Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bot?useUnicode=true"
                        + "&characterEncoding=UTF-8","root","");
            Statement stt = cnn.createStatement();
            ResultSet rs = stt.executeQuery("SELECT * FROM articles WHERE url = '" + url + "'");
            if (!rs.next()) {
                String sql = "insert into articles (title, url) values (?, ?)";
                PreparedStatement ps = cnn.prepareStatement(sql);
                ps.setString(1, title);
                ps.setString(2, url);
                ps.execute();
            }
            System.out.println(" - " + title);
            BotThread siin = new BotThread(url);
            siin.start();
            siin.join();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    public void botDelay() {
        try {
            Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bot?useUnicode=true"
                        + "&characterEncoding=UTF-8","root","");
            Statement stt = cnn.createStatement();
            ResultSet rs = stt.executeQuery("SELECT * FROM articles WHERE status = 0 LIMIT 50");
            if (rs.next()) {
                String urlGet = rs.getString("url");
                Document doc = Jsoup.connect(urlGet).get();
                String content1 = doc.select("h2.knc-sapo").text();
                Elements content2 = doc.select("#ContentDetail p");
                StringBuilder contentAll = new StringBuilder();
                for (Element element : content2) {
                    contentAll.append(element.text() + "\n");
                }
                String content = content1 + "\n" + contentAll;
                ResultSet rrs = stt.executeQuery("SELECT * FROM articles WHERE url = '" + urlGet + "'");
                if (rrs.next()) {
                    String sql = "update articles set content = ?, status = 1 where url = ?";
                    PreparedStatement ps = cnn.prepareStatement(sql);
                    ps.setString(1, content);
                    ps.setString(2, urlGet);
                    ps.execute();
                }
                Elements list = doc.select("body a");
                for (Element link : list) {
                    String url = link.attr("href");
                    String title = link.attr("title");
                    if (url.contains(".chn") && title.length() > 20) {
                        if (url.contains("http://genk.vn")) {
                            ResultSet rss = stt.executeQuery("SELECT * FROM articles WHERE url = '" + url + "'");
                            if (!rss.next()) {
                                String sql = "insert into articles (title, url) values (?, ?)";
                                PreparedStatement ps = cnn.prepareStatement(sql);
                                ps.setString(1, title);
                                ps.setString(2, url);
                                ps.execute();
                            }
                        } else {
                            String newUrl = "http://genk.vn" + url;
                            ResultSet rss = stt.executeQuery("SELECT * FROM articles WHERE url = '" + newUrl + "'");
                            if (!rss.next()) {
                                String sql = "insert into articles (title, url) values (?, ?)";
                                PreparedStatement ps = cnn.prepareStatement(sql);
                                ps.setString(1, title);
                                ps.setString(2, newUrl);
                                ps.execute();
                            }
                        }
                    }
                }
                System.out.println("Update " + Thread.currentThread().getName());
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
