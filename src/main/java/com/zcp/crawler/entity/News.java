package com.zcp.crawler.entity;

import java.util.Date;

/**
 * @author Administrator
 * @create 2019/12/17
 * @since 1.0.0
 */
public class News {

    //ID
    private Integer id;
    //标题
    private String title;
    //链接
    private String url;
    //图片
    private String image;
    //创建日期
    private Date createDate;
    //新闻日期
    private Date newsDate;
    //资源
    private String source;
    //内容
    private String content;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(Date newsDate) {
        this.newsDate = newsDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", image='" + image + '\'' +
                ", createDate=" + createDate +
                ", newsDate=" + newsDate +
                ", source='" + source + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}

