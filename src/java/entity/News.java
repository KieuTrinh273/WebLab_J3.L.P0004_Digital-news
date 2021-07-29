/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 *
 * @author DELL
 */
public class News {

    private int id;
    private String title, image, description, newsContent, writer;
    private Timestamp datePublished;

    public News() {
    }

    public News(int id, String title, String image, String description,
            String newsContent, String writer, Timestamp datePublished) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.description = description;
        this.newsContent = newsContent;
        this.writer = writer;
        this.datePublished = datePublished;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy - h:mm");
    SimpleDateFormat sdf1 = new SimpleDateFormat("aaa");
    
    public String getDatePublished() {
        return (sdf.format(datePublished) + sdf1.format(datePublished).toLowerCase());
    }
    
    public void setDatePublished(Timestamp datePublished) {
        this.datePublished = datePublished;
    }

}
