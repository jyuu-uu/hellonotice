package com.example.hellonotice;

import java.io.Serializable;

public class Post implements Serializable {
    public String title;
    public String content;
    public boolean scrap;

    public Post() {

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

    public boolean isScrap() {
        return scrap;
    }

    public void setScrap(boolean scrap) {
        this.scrap = scrap;
    }

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
        this.scrap = false;
    }
    public Post(String title, String content, boolean scrap) {
        this(title, content);
        this.scrap = scrap;
    }
}
