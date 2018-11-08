package cn.happy.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * author：  刘涛
 *
 * @create 2018-10-25 14:50
 */
public class ReplyDetail {

    private Integer id;
    private Integer invid;
    private String content;
    private String author;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInvid() {
        return invid;
    }

    public void setInvid(Integer invid) {
        this.invid = invid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
