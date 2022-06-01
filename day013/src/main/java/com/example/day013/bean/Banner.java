package com.example.day013.bean;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * @Date 2022/6/1
 */
@Entity(tableName = "banner")
public class Banner {

    @PrimaryKey(autoGenerate = true)
    private int autoId;

    private Integer id;
    private String imagepath;
    private Integer imgorder;
    private String title;
    private String url;
    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public Integer getImgorder() {
        return imgorder;
    }

    public void setImgorder(Integer imgorder) {
        this.imgorder = imgorder;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
