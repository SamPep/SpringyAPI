package com.example.springyapi;

public class Template {

    private final long id;
    private final String content;

    public Template(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}