package com.lxmajs.demo.entity;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
    private Float price;

    /**
     *
     */
    private Date createTime;
}
