package com.jeffmendez.market.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeffmendez.market.domain.service.ProductService;
import com.jeffmendez.market.domain.model.ProductDTO;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    @Autowired ProductService productService;

    @GetMapping()
    public ResponseEntity<List<ProductDTO>> getAll() {
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable("id") int productId) {
        return productService.getProduct(productId)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<ProductDTO>> getByCategory(@PathVariable("id") int categoryId) {
        return productService.getByCategory(categoryId)
                .map(products -> new ResponseEntity<>(products, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") int productId) {
        if (productService.delete(productId)) {
            return new ResponseEntity(HttpStatus.OK);
        } 
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
