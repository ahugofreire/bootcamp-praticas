package com.meli.products.resource;

import com.meli.products.domain.Product;
import com.meli.products.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
public class ProductResource {
    private final IProductService productService;

    @PostMapping("/products")
    public ResponseEntity<Product> create(@RequestBody Product product) {
        Product productCreated = this.productService.create(product);
        return ResponseEntity.created(URI.create("/products/" + productCreated.getId())).body(productCreated);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok().body(this.productService.find());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> findById(@PathVariable String id) {
        return ResponseEntity.ok().body(this.productService.findOne(id));
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateById(@PathVariable String id, Product product) {
        return ResponseEntity.ok().body(this.productService.updateOne(id, product));
    }

    @DeleteMapping("/products/{id}")
    public  ResponseEntity<?> deleteById(@PathVariable String id) {
        this.productService.removeOne(id);
        return ResponseEntity.noContent().build();
    }
}
