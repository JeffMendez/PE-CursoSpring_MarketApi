package com.jeffmendez.market.domain.repository;

import java.util.List;
import java.util.Optional;

import com.jeffmendez.market.domain.model.ProductDTO;

public interface ProductDTORepository {
    List<ProductDTO> getAll();
    Optional<List<ProductDTO>> getByCategory(int categoryId);
    Optional<List<ProductDTO>> getScarseProducts(int quantity, String active);
    Optional<ProductDTO> getProduct(int productId);
    ProductDTO save(ProductDTO product);
    void delete(int productId);
}
