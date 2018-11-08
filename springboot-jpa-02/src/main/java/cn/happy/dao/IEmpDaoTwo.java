package cn.happy.dao;

import cn.happy.entity.Emp;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;


/**
 * author：  刘涛
 *
 * @create 2018-08-15 17:43
 */
public interface IEmpDaoTwo extends Repository<Emp,Integer>{
    //按照id查询员工信息
    public Emp findByEmpid(Integer empid);

    //按照员工姓名查询员工信息
    @Query("from Emp where empname=:empname")
    public Emp findByEmpname(@Param(value = "empname") String empname);

    //修改员工信
    @Modifying
    @Query("update Emp e set e.empname=?1 where e.empid=?2")
    public int updateEmp(String empname,Integer empid);
}
