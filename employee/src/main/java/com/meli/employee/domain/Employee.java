package com.meli.employee.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
@Data
@Document(indexName = "employees")
@AllArgsConstructor
public class Employee {
    @Id
    private String id;
    private String first_name;
    private String last_name;
    private Integer age;
    private String city;
    private UF uf;
}
