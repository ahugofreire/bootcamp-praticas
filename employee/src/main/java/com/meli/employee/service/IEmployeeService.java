package com.meli.employee.service;

import com.meli.employee.domain.Employee;
import com.meli.employee.domain.UF;

import java.util.List;

public interface IEmployeeService {
    Employee create(Employee employee);
    List<Employee> find();
    Employee findOne(String id);
    Employee update(String id, Employee employee);
    List<Employee> findByState(UF uf);
    List<Employee> findByAgeGreaterAge(Integer age);
    Employee updateLastname(String id, String lastname);
    void deleteOne(String id);
}
