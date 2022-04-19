package com.meli.employee.service;

import com.meli.employee.domain.Employee;
import com.meli.employee.domain.UF;
import com.meli.employee.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class EmployeeService implements IEmployeeService{

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee create(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public List<Employee> find() {
        List<Employee> employees = new ArrayList<>();

        this.employeeRepository.findAll().iterator().forEachRemaining(employees::add);

        return employees;
    }

    @Override
    public Employee findOne(String id) {
        return this.employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Does not exist Employee to id " + id));
    }

    @Override
    public Employee update(String id, Employee employee) {
        Employee existEmployee = this.employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Does not exist Employee to id " + id));
        existEmployee.setAge(employee.getAge());
        existEmployee.setFirst_name(employee.getFirst_name());
        existEmployee.setLast_name(employee.getLast_name());
        existEmployee.setCity(employee.getCity());
        existEmployee.setUf(employee.getUf());

        return  this.employeeRepository.save(existEmployee);
    }

    @Override
    public List<Employee> findByState(UF uf) {
        return this.employeeRepository.findByUf(uf);
    }

    @Override
    public List<Employee> findByAgeGreaterAge(Integer age) {
        return this.employeeRepository.findByAgeIsGreaterThan(age);
    }

    @Override
    public Employee updateLastname(String id, String lastname) {
        Employee existEmployee = this.employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Does not exist Employee to id " + id));
        existEmployee.setLast_name(lastname);

        return this.employeeRepository.save(existEmployee);
    }


    @Override
    public void deleteOne(String id) {
        this.employeeRepository.deleteById(id);
    }
}
