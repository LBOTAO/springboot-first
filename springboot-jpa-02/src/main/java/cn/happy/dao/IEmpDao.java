package cn.happy.dao;

import cn.happy.entity.Emp;
import org.springframework.data.repository.CrudRepository;

/**
 * author：  刘涛
 *
 * @create 2018-08-15 16:25
 */
public interface IEmpDao extends CrudRepository<Emp,Integer> {
}
