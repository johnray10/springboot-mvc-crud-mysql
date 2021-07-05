package com.net.springbootmvccrudmysql.services;

import com.net.springbootmvccrudmysql.model.Employee;
import com.net.springbootmvccrudmysql.repositories.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    /** Get All List **/
    public List<Employee> getAll(){
        return employeeDao.findAll();
    }

    public Employee get(long id){
        return employeeDao.findById(id).get();
    }

    public void add(Employee employee){
        employeeDao.save(employee);
    }

    public void delete(long id){
        employeeDao.deleteById(id);
    }
}
