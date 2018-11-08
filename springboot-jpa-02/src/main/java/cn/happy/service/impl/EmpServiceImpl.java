package cn.happy.service.impl;

import cn.happy.dao.IEmpDao;
import cn.happy.dao.IEmpDaoThree;
import cn.happy.dao.IEmpDaoTwo;
import cn.happy.entity.Emp;
import cn.happy.service.IEmpService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * author：  刘涛
 *
 * @create 2018-08-15 16:34
 */
@Service("empServiceImpl")
public class EmpServiceImpl implements IEmpService {
    @Resource(name = "IEmpDao")
    private IEmpDao empDao;

    @Resource(name = "IEmpDaoTwo")
    private IEmpDaoTwo empDaoTwo;

    @Resource(name = "IEmpDaoThree")
    private IEmpDaoThree empDaoThree;

    @Override
    @Transactional
    public void save(Emp emp) {
        empDao.save(emp);
    }

    @Override
    public List<Emp> findAll() {
        return (List<Emp>)empDao.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        empDao.deleteById(id);
    }

    @Override
    public Emp findByEmpid(Integer empid) {
        return empDaoTwo.findByEmpid(empid);
    }

    @Override
    public Emp findByEmpname(String empname) {
        return empDaoTwo.findByEmpname(empname);
    }

    @Override
    @Transactional
    public int updateEmp(String empname, Integer empid) {
        return empDaoTwo.updateEmp(empname,empid);
    }

    @Override
    public List<Emp> findAllSort(Sort sort) {
        return (List<Emp>) empDaoThree.findAll(sort);
    }

    @Override
    public Page<Emp> findAllLimit(Pageable pageable) {
        return empDaoThree.findAll(pageable);
    }

}
