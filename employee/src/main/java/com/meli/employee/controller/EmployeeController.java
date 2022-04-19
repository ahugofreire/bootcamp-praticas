package com.meli.employee.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.meli.employee.domain.Employee;
import com.meli.employee.domain.UF;
import com.meli.employee.dto.RequestLastNameDTO;
import com.meli.employee.service.IEmployeeService;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
public class EmployeeController {

    private final IEmployeeService employeeService;
    private final ObjectMapper objectMapper;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> findAll() {
        return ResponseEntity.ok().body(this.employeeService.find());
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> findById(@PathVariable String id) {
        return ResponseEntity.ok().body(this.employeeService.findOne(id));
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> update(@PathVariable String id, @RequestBody Employee employee) {
        return ResponseEntity.ok().body(this.employeeService.update(id, employee));
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<?> remove(@PathVariable String id) {
        this.employeeService.deleteOne(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/employees/{id}")
    public ResponseEntity<Employee> updateLastName(@PathVariable String id, @RequestBody RequestLastNameDTO req) {

        return ResponseEntity.ok().body(this.employeeService.updateLastname(id, req.getLast_name()));
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        Employee employeeC = this.employeeService.create(employee);
        return ResponseEntity.created(URI.create("/employees/" + employeeC.getId())).body(employeeC);
    }

    @GetMapping("/employees/state/{uf}")
    public ResponseEntity<List<Employee>> findByUf(@PathVariable UF uf) {
        return ResponseEntity.ok().body(this.employeeService.findByState(uf));
    }

    @GetMapping("/employees/age")
    public ResponseEntity<List<Employee>> findByAge(@RequestParam(required = false) Integer num) {

        return ResponseEntity.ok().body(this.employeeService.findByAgeGreaterAge(num));
    }
}
