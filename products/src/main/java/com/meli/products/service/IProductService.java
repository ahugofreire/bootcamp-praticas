package com.meli.products.service;

import com.meli.products.domain.Product;

import java.util.List;

public interface IProductService {
    Product create(Product product);
    Product findOne(String id);
    List<Product> find();
    Product updateOne(String id, Product product);
    void removeOne(String id);
}
