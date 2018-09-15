package com.example.hh.fangyan2.bean;

public class Icon {
    private int iId;
    private String iName;
    private String url;
    public Icon() {

    }

    public Icon(int iId, String iName,String url) {
        this.iId = iId;
        this.iName = iName;
        this.url=url;
    }

    public int getiId() {
        return iId;
    }

    public String getiName() {
        return iName;
    }

    public void setiId(int iId) {
        this.iId = iId;
    }

    public void setiName(String iName) {
        this.iName = iName;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
