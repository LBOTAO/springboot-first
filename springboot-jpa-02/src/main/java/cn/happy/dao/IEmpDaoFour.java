package cn.happy.dao;

import cn.happy.entity.Emp;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * author：  刘涛
 *
 * @create 2018-08-16 13:38
 */

public interface IEmpDaoFour {

    public List<Map<String, Object>> findAll();

    public List<Emp> findAllJdbcTwo();

    public int insert(Emp emp);

}
