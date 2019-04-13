package com.lxmajs.library.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

public class Book {

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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public int getAuthor_id() {
        return Author_id;
    }

    public void setAuthor_id(int author_id) {
        Author_id = author_id;
    }

    public String getAvatar_src() {
        return Avatar_src;
    }

    public void setAvatar_src(String avatar_src) {
        Avatar_src = avatar_src;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    /**
     *
     */
    private Integer id;

    /**
     *
     */
    private String title;

    /**
     *
     */
    @JsonInclude(JsonInclude.Include.NON_NULL )
    private Float price;

    /**
     * 作者id
     */
    private int Author_id;

    /**
     * 书籍封面
     */
    private String Avatar_src;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss a", locale = "zh", timezone = "GMT-8")
    private Date createTime;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss a", locale = "zh", timezone = "GMT-8")
    private Date lastEditTime;
}
