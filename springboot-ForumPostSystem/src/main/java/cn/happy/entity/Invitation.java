package cn.happy.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * author：  刘涛
 *
 * @create 2018-10-25 14:46
 */
public class Invitation {

    private Integer id;
    private String title;
    private String summary;
    private String author;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createdate;

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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}
