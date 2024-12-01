package com.jeffmendez.market.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeffmendez.market.domain.model.ProductDTO;
import com.jeffmendez.market.domain.repository.ProductDTORepository;

import jakarta.transaction.Transactional;

@Service
public class ProductService {
    @Autowired ProductDTORepository productDTORepository;
    
    public List<ProductDTO> getAll() {
        return productDTORepository.getAll();
    }

    public Optional<ProductDTO> getProduct(int productId) {
        return productDTORepository.getProduct(productId);
    }

    public Optional<List<ProductDTO>> getByCategory(int categoryId) {
        return productDTORepository.getByCategory(categoryId);
    }

    @Transactional
    public ProductDTO save(ProductDTO product) {
        return productDTORepository.save(product);
    }

    public boolean delete(int productId) {
        if (getProduct(productId).isPresent()) {
            productDTORepository.delete(productId);
            return true;
        }
        return false;
    }
}
