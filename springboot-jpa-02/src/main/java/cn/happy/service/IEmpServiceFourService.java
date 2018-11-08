package cn.happy.service;

import cn.happy.entity.Emp;

import java.util.List;
import java.util.Map;

/**
 * author：  刘涛
 *
 * @create 2018-08-16 13:47
 */
public interface IEmpServiceFourService {

    public List<Map<String, Object>> findAll();

    public List<Emp> findAllJdbcTwo();

    public int insert(Emp emp);
}
