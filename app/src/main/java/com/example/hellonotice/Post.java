package com.example.hellonotice;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Post implements Serializable {
    public String id;
    public String title;
    public String content;
    public boolean scrap;

    public Post() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    public Post(String id, String title, String content, boolean scrap) {
        this(title, content, scrap);
        this.id = id;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("id", this.getId());
        result.put("content", this.getContent());
        result.put("title", this.getTitle());
        result.put("scrap", this.isScrap());
        return result;
    }
}
