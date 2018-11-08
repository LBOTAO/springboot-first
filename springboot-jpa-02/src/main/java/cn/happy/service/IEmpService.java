package cn.happy.service;

import cn.happy.entity.Emp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * author：  刘涛
 *
 * @create 2018-08-15 16:33
 */
public interface IEmpService {
    //添加
    public void save(Emp emp);
   //查询全部
    public List<Emp> findAll();
    //按id删除员工
    public void deleteById(Integer id);
    //按id查询员工信息
    public Emp findByEmpid(Integer empid);
    //按照员工姓名查询员工信息
    public Emp findByEmpname(String empname);
    //修改
    public int updateEmp(String empname,Integer empid);

    //排序
    public List<Emp> findAllSort(Sort sort);
    //分页
    public Page<Emp> findAllLimit(Pageable pageable);

}
