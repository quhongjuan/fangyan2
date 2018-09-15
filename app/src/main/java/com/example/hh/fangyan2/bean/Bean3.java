package com.example.hh.fangyan2.bean;

public class Bean3 {
    private int iId;
    private String content;
    private String url;

    public Bean3(String content, String url,int id) {
        this.content = content;
        this.url = url;
        this.iId=id;
    }
    public int getiId() {
        return iId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setiId(int iId) {
        this.iId = iId;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
