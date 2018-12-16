package com.nf147.sim.entity;

import java.util.Date;

public class Post {
    private Integer p_id;

    private Integer a_id;

    private String p_title;

    private String p_content;

    private Date p_date;

    private Author author;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }

    public Integer getA_id() {
        return a_id;
    }

    public void setA_id(Integer a_id) {
        this.a_id = a_id;
    }

    public String getP_title() {
        return p_title;
    }

    public void setP_title(String p_title) {
        this.p_title = p_title == null ? null : p_title.trim();
    }

    public String getP_content() {
        return p_content;
    }

    public void setP_content(String p_content) {
        this.p_content = p_content == null ? null : p_content.trim();
    }

    public Date getP_date() {
        return p_date;
    }

    public void setP_date(Date p_date) {
        this.p_date = p_date;
    }


    @Override
    public String toString() {
        return "Post{" +
                "p_id=" + p_id +
                ", a_id=" + a_id +
                ", p_title='" + p_title + '\'' +
                ", p_content='" + p_content + '\'' +
                ", p_date=" + p_date +
                ", author=" + author +
                '}';
    }
}