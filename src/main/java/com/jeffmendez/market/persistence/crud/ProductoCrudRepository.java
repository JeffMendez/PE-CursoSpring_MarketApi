package com.jeffmendez.market.persistence.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jeffmendez.market.persistence.entity.Producto;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    // Custom
    @Query(value = "SELECT * FROM productos WHERE ID_CATEGORIA = ?", nativeQuery = true)
    List<Producto> getByCategoria(int idCategoria);

    // Query Methods
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, String estado);
}
