package com.example.Pojo;

import lombok.Data;

import java.util.Date;
@Data
public class Book {
    private Integer id;
    private  String name;
    private String author;
    private Date publishDate;
    private double price;
    private boolean borrowed;
    private Date updateDate;

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
