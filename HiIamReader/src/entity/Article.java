/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Ngo Van Tuan
 */
public class Article {
    private String url;
    private String title;
    private String content;
    private int status;

    public Article() {
    }

    public Article(String url, String title,  int status) {
        this.url = url;
        this.title = title;
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Article{" + "url=" + url + ", title=" + title + ", status=" + status + '}';
    }
}
