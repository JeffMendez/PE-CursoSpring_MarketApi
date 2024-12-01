package com.jeffmendez.market.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jeffmendez.market.domain.model.ProductDTO;
import com.jeffmendez.market.domain.repository.ProductDTORepository;
import com.jeffmendez.market.persistence.crud.ProductoCrudRepository;
import com.jeffmendez.market.persistence.entity.Producto;
import com.jeffmendez.market.persistence.mapper.ProductMapper;

@Repository
public class ProductoRepository implements ProductDTORepository {
    
    @Autowired private ProductoCrudRepository productoCrudRepository;
    @Autowired private ProductMapper mapper;
    
    @Override
    public List<ProductDTO> getAll() {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toDtoProducts(productos);
    }

    @Override
    public Optional<List<ProductDTO>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toDtoProducts(productos));
    }

    @Override
    public Optional<List<ProductDTO>> getScarseProducts(int quantity, String active) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, active);
        return productos.map(prods -> mapper.toDtoProducts(prods));
    }

    @Override
    public Optional<ProductDTO> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(prod -> mapper.toDto(prod));
    }

    @Override
    public ProductDTO save(ProductDTO product) {
        Producto producto = mapper.toEntity(product);
        producto.setIdProducto(null);

        return mapper.toDto(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int productId) {
        productoCrudRepository.deleteById(productId);
    }
}
