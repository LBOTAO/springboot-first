package cn.happy.dao.impl;

import cn.happy.dao.IEmpDaoFour;
import cn.happy.entity.Emp;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * author：  刘涛
 *
 * @create 2018-08-16 13:39
 */
@Repository
public class EmpDaoFourImpl implements IEmpDaoFour {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String, Object>> findAll() {
        String sql="select * from emp";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        return list;
    }

    @Override
    public List<Emp> findAllJdbcTwo() {
        String sql="select * from emp";
        List<Emp> empList=jdbcTemplate.query(sql, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet rs, int i) throws SQLException {
                Emp emp=new Emp();
                emp.setEmpid(rs.getInt("empid"));
                emp.setEmpname(rs.getString("empname"));
                emp.setEmpphone(rs.getString("empphone"));
                return emp;
            }
        });
        return empList;
    }

    @Override
    public int insert(Emp emp) {
        String sql="insert into emp(empname,empphone) values(?,?)";
        int count = jdbcTemplate.update(sql, emp.getEmpname(), emp.getEmpphone());
        return count;
    }
}
