package com.lemans.test.web.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private Integer userId;
    private Integer id;
    private String title;
    private String body;
    private String sequence;


    public User() {
    }

    public User(Integer userId, Integer id, String title, String body, String sequence) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
        this.sequence = sequence;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", sequence='" + sequence + '\'' +
                '}';
    }
}
