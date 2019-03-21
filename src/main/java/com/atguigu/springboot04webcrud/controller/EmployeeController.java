package com.atguigu.springboot04webcrud.controller;

import com.atguigu.springboot04webcrud.dao.DepartmentDao;
import com.atguigu.springboot04webcrud.dao.EmployeeDao;
import com.atguigu.springboot04webcrud.entities.Department;
import com.atguigu.springboot04webcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    //查询所有员工列表
    @GetMapping("emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    @PostMapping("emp")
    public String addEmp(Employee employee) {
        employeeDao.save(employee);
        //System.out.println(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id")Integer id,Model  model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        //查询部门列表
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    @PutMapping("/emp")
    public String updateEmployee(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String delEmployee(@PathVariable("id")Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
