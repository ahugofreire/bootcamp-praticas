package com.meli.products.service;

import com.meli.products.domain.Product;
import com.meli.products.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class ProductServiceImpl implements IProductService{

    private final ProductRepository productRepository;

    @Override
    public Product create(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public Product findOne(String id) {
        return this.productRepository.findById(id).orElseThrow(() -> new RuntimeException("Does exist id"));
    }

    @Override
    public List<Product> find() {
        List<Product> products = new ArrayList<>();

        this.productRepository.findAll().iterator().forEachRemaining(products::add);

        return products;
    }

    @Override
    public Product updateOne(String id, Product product) {
        Product productExist = this.productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Does exist id"));

        productExist.setName(product.getName());
        productExist.setCategory(product.getCategory());
        productExist.setPrice(product.getPrice());
        productExist.setQuantity(product.getQuantity());
        productExist.setWareHouse(product.getWareHouse());

        return this.productRepository.save(productExist);
    }

    @Override
    public void removeOne(String id) {
        this.productRepository.deleteById(id);
    }
}
