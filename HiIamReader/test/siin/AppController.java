/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siin;

import entity.Article;
import entity.Category;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Ngo Van Tuan
 */
public class AppController implements Initializable {
    @FXML
    ArrayList<Article> listArticleVN = new ArrayList(Arrays.asList());
    @FXML
    ArrayList<Article> listArticleDT = new ArrayList(Arrays.asList());
    @FXML
    ArrayList<Category> listCategoryVN = new ArrayList(Arrays.asList());
    @FXML
    ArrayList<Category> listCategoryDT = new ArrayList(Arrays.asList());
    
    @FXML
    private ListView listViewVN;
    @FXML
    private ListView listViewDT;
    
    @FXML
    ListView<String> listVN = new ListView<>();
    @FXML
    ListView<String> listDT = new ListView<>();
    
    @FXML
    public void printListArticlesDT () {
        ObservableList<String> items = FXCollections.observableArrayList();
        for (int i = 0; i < listArticleDT.size(); i++) {
            String title = listArticleDT.get(i).getTitle();
            String url = listArticleDT.get(i).getUrl();
            items.add(title);
            listDT.setItems(items);
        }
        listViewDT.setItems(items);
    }
    
    @FXML
    public void printListArticlesVN () {
        ObservableList<String> items = FXCollections.observableArrayList();
        for (int i = 0; i < listArticleVN.size(); i++) {
            String title = listArticleVN.get(i).getTitle();
            String url = listArticleVN.get(i).getUrl();
            items.add(title);
            listVN.setItems(items);
        }
        listViewVN.setItems(items);
    }
    
    @FXML
    public void getArticlesDT (ActionEvent event) {
        try {
            if (listArticleDT.size() == 0) {
                Document doc = Jsoup.connect("http://dantri.com.vn/").get();
                Elements newsHeadlines = doc.select(".box2 ul.ulnew h4 a");
                for (Element headline : newsHeadlines) {
                    String url = "http://dantri.com.vn" + headline.attr("href");
                    String title = headline.text();
                    Article article = new Article(url, title, 1);
                    listArticleDT.add(article);
                }
            }
            printListArticlesDT();
        } catch (Exception e) {
            System.err.println("Không thể lấy tin!");
        }
    }
    
    @FXML
    public void getArticlesVN (ActionEvent event) {
        try {
            if (listArticleVN.size() == 0) {
                Document doc = Jsoup.connect("https://vnexpress.net/").get();
                Elements newsHeadlines = doc.select(".container .sidebar_home_1 h3.title_news a:first-child");
                for (Element headline : newsHeadlines) {
                    String url = headline.attr("href");
                    String title = headline.text();
                    Article article = new Article(url, title, 1);
                    listArticleVN.add(article);
                }
            }
            printListArticlesVN();
        } catch (Exception e) {
            System.err.println("Không thể lấy tin!");
        }
    }
    
    
    
    @FXML 
    private Button closeDT;
    
    @FXML
    public void close () {
        Stage stage = (Stage) closeDT.getScene().getWindow();
        stage.close();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //  TODO
    }
}
