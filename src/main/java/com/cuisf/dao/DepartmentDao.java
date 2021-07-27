package com.cuisf.dao;


import com.cuisf.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {
    //模拟数据库中的数据
    private static Map<Integer, Department> departments = null;

    static {
         departments = new HashMap<>();  //创建一个部门表

        departments.put(101,new Department(101,"开发"));
        departments.put(102,new Department(102,"测试"));
        departments.put(103,new Department(103,"设计"));
        departments.put(104,new Department(104,"产品"));
        departments.put(105,new Department(105,"业务"));
        departments.put(106,new Department(106,"商务"));
        departments.put(107,new Department(107,"运维"));


    }



    //获取所有部门的信息
    public Collection<Department> getDepartments(){

        return departments.values();
    }

    //通过id 获取部门
    public Department getDepartmentById(Integer id){

        return departments.get(id);
    }

}
