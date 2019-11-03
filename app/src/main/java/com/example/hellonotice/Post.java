package com.example.hellonotice;

import java.io.Serializable;

public class Post implements Serializable {
    public String title;
    public String content;

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

    public boolean scrap;

    public Post(String s1, String s2) {
        this.title = s1;
        this.content = s2;
        scrap = false;
    }
    public Post(String s1, String s2, boolean b) {
        this(s1, s2);
        scrap = b;
    }
}
