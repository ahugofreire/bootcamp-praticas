package com.meli.employee.repository;

import com.meli.employee.domain.Employee;
import com.meli.employee.domain.UF;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends ElasticsearchRepository<Employee, String> {
    List<Employee> findByUf(UF uf);
    List<Employee> findByAgeIsGreaterThan(Integer age);
}
