package com.meli.products.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;

@Data
@Document(indexName = "products")
public class Product {
    @Id
    private String id;
    private String name;
    private String category;
    private BigDecimal price;
    private Integer quantity;
    private String wareHouse;
}
