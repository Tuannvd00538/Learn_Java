/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Article;
import entity.Category;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Ngo Van Tuan
 */
public class DantriReader implements Reader{
    Scanner input = new Scanner(System.in);
    ArrayList<Article> listArticle = new ArrayList(Arrays.asList());
    ArrayList<Category> listCategory = new ArrayList(Arrays.asList());
    
    public int indexArticles;
    public int indexCategorys;
    
    public void printListArticles () {
        for (int i = 0; i < listArticle.size(); i++) {
            Article get = listArticle.get(i);
            System.out.println((i + 1) + ". " + get.getTitle());
        }
    }
    
    public void printListCategorys () {
        for (int i = 0; i < listCategory.size(); i++) {
            Category get = listCategory.get(i);
            if (i == 0) {
                get.setName("Trang chủ");
                get.setUrl("http://dantri.com.vn/");
            }
            System.out.println((i + 1) + ". " + get.getName());
        }
    }
    
    @Override
    public int getIndexArticles () {
        System.out.println("-------------------------------");
        System.out.println("Vui lòng chờ lấy tin trang chủ...");
        try {
            if (listArticle.size() == 0) {
                Document doc = Jsoup.connect("http://dantri.com.vn/").get();
                Elements newsHeadlines = doc.select(".box2 ul.ulnew h4 a");
                for (Element headline : newsHeadlines) {
                    String url = "http://dantri.com.vn" + headline.attr("href");
                    String title = headline.text();
                    Article article = new Article(url, title, 1);
                    listArticle.add(article);
                }
            }
            printListArticles();
        } catch (Exception e) {
            System.err.println("Không thể lấy tin!");
        }
        System.out.println("-------------------------------");
        System.out.println("Vui lòng chọn tin:");
        int choice = input.nextInt();
        indexArticles = choice - 1;
        return choice;
    }
    
    @Override
    public int getListCategorys () {
        System.out.println("-------------------------------");
        System.out.println("Vui lòng chờ lấy danh sách danh mục...");
        try {
            if (listCategory.size() == 0) {
                Document doc = Jsoup.connect("http://dantri.com.vn/").get();
                Elements newsHeadlines = doc.select(".nav-wrap .wid1004 ul.nav li a");
                for (Element nav : newsHeadlines) {
                    String name = nav.text();
                    String url = nav.attr("href");
                    Category category = new Category(name, url);
                    listCategory.add(category);
                }
            }
            printListCategorys();
        } catch (Exception e) {
            System.err.println("Không thể lấy tin!");
        }
        System.out.println("-------------------------------");
        System.out.println("Vui lòng chọn danh mục:");
        int choice = input.nextInt();
        indexCategorys = choice - 1;
        if (choice == 1) {
            getIndexArticles();
        }
        return choice;
    }
    
    @Override
    public int getArticlesByCategory () {
        System.out.println("-------------------------------");
        System.out.println("Vui lòng chờ lấy tin...");
        try {
            Document doc = Jsoup.connect(listCategory.get(indexCategorys).getUrl()).get();
            Elements newsHeadlines = doc.select(".container #listcheckepl .mr1 h2 a");
            listArticle.clear();
            for (Element headline : newsHeadlines) {
                String url = "http://dantri.com.vn" + headline.attr("href");
                String title = headline.text();
                Article article = new Article(url, title, 1);
                listArticle.add(article);
            }
            for (int i = 0; i < listArticle.size(); i++) {
                Article get = listArticle.get(i);
                System.out.println((i + 1) + ". " + get.getTitle());
            }
        } catch (Exception e) {
            try {
                Document doc = Jsoup.connect("http://dantri.com.vn" + listCategory.get(indexCategorys).getUrl()).get();
                Elements newsHeadlines = doc.select(".container #listcheckepl .mr1 h2 a");
                listArticle.clear();
                for (Element headline : newsHeadlines) {
                    String url = "http://dantri.com.vn" + headline.attr("href");
                    String title = headline.text();
                    Article article = new Article(url, title, 1);
                    listArticle.add(article);
                }
                for (int i = 0; i < listArticle.size(); i++) {
                    Article get = listArticle.get(i);
                    System.out.println((i + 1) + ". " + get.getTitle());
                }
            } catch (Exception err) {
                System.err.println("Không thể lấy tin!");
            }
        }
        System.out.println("-------------------------------");
        System.out.println("0. Quay lại");
        System.out.println("-------------------------------");
        System.out.println("Vui lòng chọn tin:");
        int choice = input.nextInt();
        indexArticles = choice - 1;
        return choice;
    }
    
    @Override
    public int getArticleDetail () {
        System.out.println("Tiêu đề: " + listArticle.get(indexArticles).getTitle());
        System.out.println("-------------------------------");
        try {
            Document doc = Jsoup.connect(listArticle.get(indexArticles).getUrl()).get();
            Elements time = doc.select(".container .box26 span.tt-capitalize");
            System.out.println("Ngày đăng bài: " + time.text());
            System.out.println("-------------------------------");
            Elements description = doc.select(".container h2.fon33");
            System.out.println("Description: " + description.text());
            System.out.println("-------------------------------");
            Elements content = doc.select(".container #divNewsContent p");
            for (Element contentArticle : content) {
                if (contentArticle.text() == null) {
                    System.err.println("Oops! Có lỗi xảy ra.");
                } else {
                    System.out.println(contentArticle.text());
                }
            }
            Elements tag = doc.select(".container .news-tag");
            System.out.println(tag.text());
        } catch (Exception e) {
            System.err.println("Không thể lấy tin!");
        }
        System.out.println("-------------------------------");
        System.out.println("0. Quay lại");
        int choice = input.nextInt();
        return choice;
    }
}
