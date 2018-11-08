package cn.happy.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * author：  刘涛
 *
 * @create 2018-08-15 16:31
 */
@Entity //hibernate持久化类
public class Emp {
    @Id
    @GeneratedValue   //主键生成策略
    private Integer empid;
    private String empname;
    private String empphone;

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getEmpphone() {
        return empphone;
    }

    public void setEmpphone(String empphone) {
        this.empphone = empphone;
    }
}
