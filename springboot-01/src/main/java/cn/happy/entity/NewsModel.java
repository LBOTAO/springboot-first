package cn.happy.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * author：  刘涛
 *
 * @create 2018-08-03 10:33
 */
public class NewsModel implements Serializable {
    private Integer nid;

    private Integer ntid;

    private String ntitle;

    private String nauthor;
    //年月日  东八区
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date ncreatedate;

    private String npicpath;

    private String ncontent;

    private Date nmodifydate;

    private String nsummary;

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public Integer getNtid() {
        return ntid;
    }

    public void setNtid(Integer ntid) {
        this.ntid = ntid;
    }

    public String getNtitle() {
        return ntitle;
    }

    public void setNtitle(String ntitle) {
        this.ntitle = ntitle;
    }

    public String getNauthor() {
        return nauthor;
    }

    public void setNauthor(String nauthor) {
        this.nauthor = nauthor;
    }

    public Date getNcreatedate() {
        return ncreatedate;
    }

    public void setNcreatedate(Date ncreatedate) {
        this.ncreatedate = ncreatedate;
    }

    public String getNpicpath() {
        return npicpath;
    }

    public void setNpicpath(String npicpath) {
        this.npicpath = npicpath;
    }

    public String getNcontent() {
        return ncontent;
    }

    public void setNcontent(String ncontent) {
        this.ncontent = ncontent;
    }

    public Date getNmodifydate() {
        return nmodifydate;
    }

    public void setNmodifydate(Date nmodifydate) {
        this.nmodifydate = nmodifydate;
    }

    public String getNsummary() {
        return nsummary;
    }

    public void setNsummary(String nsummary) {
        this.nsummary = nsummary;
    }
}
