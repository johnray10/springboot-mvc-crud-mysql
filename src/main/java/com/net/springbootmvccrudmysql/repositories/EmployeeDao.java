package com.net.springbootmvccrudmysql.repositories;

import com.net.springbootmvccrudmysql.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long> {

}
