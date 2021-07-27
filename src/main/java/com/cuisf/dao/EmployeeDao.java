package com.cuisf.dao;

import com.cuisf.pojo.Department;
import com.cuisf.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//员工dao
@Repository
public class EmployeeDao {

    @Autowired
    private DepartmentDao departmentDao;

    //模拟数据库中的数据
    private static Map<Integer, Employee> employees = null;

    static {
        employees = new HashMap<>();  //创建一个员工表

        employees.put(1001,new Employee(1001,"zhangsan","147852@qq.com",1,new Department(101,"开发")));
        employees.put(1002,new Employee(1002,"lisi","1123111@163.com",0,new Department(102,"测试")));
        employees.put(1003,new Employee(1003,"海歌","11232321@163.com",1,new Department(102,"测试")));
        employees.put(1004,new Employee(1004,"布丁","1114444411@163.com",1,new Department(102,"测试")));
        employees.put(1005,new Employee(1005,"小妹","111444@163.com",0,new Department(102,"测试")));
        employees.put(1006,new Employee(1006,"喜洋洋","11wehbf111@163.com",0,new Department(102,"测试")));
        employees.put(1007,new Employee(1007,"村霸","11sarvadva11@163.com",0,new Department(102,"测试")));


    }

    //添加员工
    private static Integer initId = 1008;

    public void saveEmployee(Employee employee){
        if (employee.getId() == null){
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));

        employees.put(employee.getId(),employee);
    }


    //全查询员工

    public Collection<Employee> getAll()
    {
        return employees.values();
    }


    //通过id查询员工
     public Employee getEmployeeById(Integer id){

        return employees.get(id);
     }


}
