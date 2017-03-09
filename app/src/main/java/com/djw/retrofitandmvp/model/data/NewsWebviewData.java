package com.djw.retrofitandmvp.model.data;

/**
 * Created by JasonDong on 2017/3/6.
 */

public class NewsWebviewData {
    private int count;
    private String description;
    private int fcount;
    private String fromname;
    private String fromurl;
    private int id;
    private String img;
    private String keywords;
    private String message;
    private int rcount;
    private boolean status;
    private long time;
    private String title;
    private int topclass;
    private String url;

    public void setCount(int count) {
        this.count = count;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFcount(int fcount) {
        this.fcount = fcount;
    }

    public void setFromname(String fromname) {
        this.fromname = fromname;
    }

    public void setFromurl(String fromurl) {
        this.fromurl = fromurl;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setRcount(int rcount) {
        this.rcount = rcount;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTopclass(int topclass) {
        this.topclass = topclass;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCount() {
        return count;
    }

    public String getDescription() {
        return description;
    }

    public int getFcount() {
        return fcount;
    }

    public String getFromname() {
        return fromname;
    }

    public String getFromurl() {
        return fromurl;
    }

    public int getId() {
        return id;
    }

    public String getImg() {
        return img;
    }

    public String getKeywords() {
        return keywords;
    }

    public String getMessage() {
        return message;
    }

    public int getRcount() {
        return rcount;
    }

    public boolean isStatus() {
        return status;
    }

    public long getTime() {
        return time;
    }

    public String getTitle() {
        return title;
    }

    public int getTopclass() {
        return topclass;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "NewsWebviewData{" +
                "count=" + count +
                ", description='" + description + '\'' +
                ", fcount=" + fcount +
                ", fromname='" + fromname + '\'' +
                ", fromurl='" + fromurl + '\'' +
                ", id=" + id +
                ", img='" + img + '\'' +
                ", keywords='" + keywords + '\'' +
                ", message='" + message + '\'' +
                ", rcount=" + rcount +
                ", status=" + status +
                ", time=" + time +
                ", title='" + title + '\'' +
                ", topclass=" + topclass +
                ", url='" + url + '\'' +
                '}';
    }
}
