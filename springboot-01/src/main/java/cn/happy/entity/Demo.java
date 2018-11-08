package cn.happy.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * author：  刘涛
 *
 * @create 2018-08-10 16:00
 */
public class Demo {
    private Integer id;

    private  String name;

    //年月日  东八区
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}
