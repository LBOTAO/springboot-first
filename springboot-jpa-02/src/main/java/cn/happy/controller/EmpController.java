package cn.happy.controller;

import cn.happy.entity.Emp;
import cn.happy.service.IEmpService;
import cn.happy.service.IEmpServiceFourService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * author：  刘涛
 *
 * @create 2018-08-15 16:36
 */
@Controller
public class EmpController {
    @Resource(name = "empServiceImpl")
    private IEmpService empService;

    @Resource(name = "empServiceFourImpl")
    private IEmpServiceFourService empServiceFourService;

    @RequestMapping("/save")
    @ResponseBody
    public String save(){
        Emp emp=new Emp();
        emp.setEmpname("王嘉尔");
        emp.setEmpphone("1356789654");
        empService.save(emp);
        return "save ok!";
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public Object findAll(){
        List<Emp> empList = empService.findAll();
        return empList;
    }

    @RequestMapping("/deleteById")
    @ResponseBody
    public String deleteById(){
       empService.deleteById(2);
       return "delete ok!";
    }


    @RequestMapping("/findByEmpid")
    @ResponseBody
    public Object findByEmpid(){
        Emp byEmpid = empService.findByEmpid(1);
        return byEmpid;
    }

    @RequestMapping("/findByEmpname")
    @ResponseBody
    public Object findByEmpname(){
        Emp byEmpname = empService.findByEmpname("王嘉尔");
        return byEmpname;
    }

    @RequestMapping("/updateEmp")
    @ResponseBody
    public Object updateEmpname(){
        int updateEmp = empService.updateEmp("小草青青", 1);
        return updateEmp;
    }

    @RequestMapping("/findAllSort")
    @ResponseBody
    public Object findAllSort(){
       /* Sort sort=new Sort(Sort.Direction.DESC,"empphone");*/
        Sort sort=new Sort(Sort.Direction.DESC,"empid").and(new Sort(Sort.Direction.ASC,"empname"));
        List<Emp> list = empService.findAllSort(sort);
        return list;
    }

    //分页带排序
    @RequestMapping("/findAllLimit")
    @ResponseBody
    public Object findAllLimit(){
        Sort sort=new Sort(Sort.Direction.ASC,"empid");
        Pageable pageable= PageRequest.of(0,2,sort);
        Page<Emp> list = empService.findAllLimit(pageable);
        return list;
    }

    @RequestMapping("/findAllJdbc")
    @ResponseBody
    public Object findAllJdbc(){
        List<Map<String, Object>> list = empServiceFourService.findAll();
        return list;
    }

    @RequestMapping("/findAllJdbcTwo")
    @ResponseBody
    public Object findAllJdbcTwo(){
        List<Emp> list = empServiceFourService.findAllJdbcTwo();
        return list;
    }

    @RequestMapping("/insertEmp")
    @ResponseBody
    public Object insert(){
        Emp emp=new Emp();
        emp.setEmpname("呵呵哒");
        emp.setEmpphone("110");
        int count = empServiceFourService.insert(emp);
        return count;
    }

}
