package com.cuisf.controller;

import com.cuisf.dao.DepartmentDao;
import com.cuisf.dao.EmployeeDao;
import com.cuisf.pojo.Department;
import com.cuisf.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    /**
     *  requestMapping  具有类属性的，可以惊醒Get post Put 等其他注释中的请求方式
     *  getMapping 是get 请求中方法中的一个特例，只是RequestMapping 的一个延伸   目的是为了提高清晰度
     */
    @RequestMapping("/emps")
    public String findAll(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("employees",employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model){

        //查询部门的信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/add";
    }


    @PostMapping("/emp")
    public String addEmp(Employee employee){
        System.out.println("employee:==="+employee);
        employeeDao.saveEmployee(employee);
        return "redirect:/emps";
    }


    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id") Integer id, Model model){

        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("emp",employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/update";
    }

    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee){
        employeeDao.saveEmployee(employee);
        return "redirect:/emps";
    }
    @GetMapping("/deleteEmp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id, Model model){

    //    employeeDao.delete(id);
        return "redirect:/emps";
    }


}
