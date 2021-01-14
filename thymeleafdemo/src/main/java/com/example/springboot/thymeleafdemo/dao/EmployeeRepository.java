package com.example.springboot.thymeleafdemo.dao;

import com.example.springboot.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository <Employee, Integer>{

    // thet's it ... no need to write any code )

    // add a method to sort by last name
    public List<Employee> findAllByOrderByLastName();
}
