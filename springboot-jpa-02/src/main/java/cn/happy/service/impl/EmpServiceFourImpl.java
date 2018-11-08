package cn.happy.service.impl;

import cn.happy.dao.IEmpDaoFour;
import cn.happy.entity.Emp;
import cn.happy.service.IEmpServiceFourService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * author：  刘涛
 *
 * @create 2018-08-16 13:48
 */
@Service("empServiceFourImpl")
public class EmpServiceFourImpl implements IEmpServiceFourService {
    @Resource(name = "empDaoFourImpl")
    private IEmpDaoFour empDaoFour;

    @Override
    public List<Map<String, Object>> findAll() {
        return empDaoFour.findAll();
    }

    @Override
    public List<Emp> findAllJdbcTwo() {
        return empDaoFour.findAllJdbcTwo();
    }

    @Override
    public int insert(Emp emp) {
        return empDaoFour.insert(emp);
    }
}
