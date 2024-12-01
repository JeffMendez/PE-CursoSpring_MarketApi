package com.jeffmendez.market.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.jeffmendez.market.domain.model.ProductDTO;
import com.jeffmendez.market.persistence.entity.Producto;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    
    @Mapping(source = "idProducto", target = "productId")
    @Mapping(source = "idCategoria", target = "categoryId")
    @Mapping(source = "nombre", target = "name")
    @Mapping(source = "precioVenta", target = "price")
    @Mapping(source = "cantidadStock", target = "stock")
    @Mapping(source = "estado", target = "active")
    @Mapping(source = "categoria", target = "category")
    ProductDTO toDto(Producto producto);
    List<ProductDTO> toDtoProducts(List<Producto> productos);

    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras", ignore = true)
    Producto toEntity(ProductDTO productDTO);
}
