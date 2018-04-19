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
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Ngo Van Tuan
 */
public class BotThread extends Thread{
    
    private String url;
    
    public BotThread(String url) {
        this.url = url;
    }
    
    @Override
    public void run() {
        try {
            Document doc = Jsoup.connect(this.url).get();
            String content1 = doc.select("h2.knc-sapo").text();
            Elements content2 = doc.select("#ContentDetail p");
            StringBuilder contentAll = new StringBuilder();
            for (Element element : content2) {
                contentAll.append(element.text() + "\n");
            }
            String content = content1 + "\n" + contentAll;
            Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bot?useUnicode=true"
                        + "&characterEncoding=UTF-8","root","");
            Statement stt = cnn.createStatement();
            ResultSet rs = stt.executeQuery("SELECT * FROM articles WHERE url = '" + this.url + "'");
            if (rs.next()) {
                String sql = "update articles set content = ?, status = 1 where url = ?";
                PreparedStatement ps = cnn.prepareStatement(sql);
                ps.setString(1, content);
                ps.setString(2, this.url);
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
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
