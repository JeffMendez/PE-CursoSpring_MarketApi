package com.jeffmendez.market.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.jeffmendez.market.domain.model.PurchaseItemDTO;
import com.jeffmendez.market.persistence.entity.CompraProducto;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {
    
    @Mapping(source = "id.idProducto", target = "productId")
    @Mapping(source = "cantidad", target = "quantity")
    @Mapping(source = "total", target = "total")
    @Mapping(source = "estado", target = "active")
    PurchaseItemDTO toDto(CompraProducto comprasProducto);

    @InheritInverseConfiguration
    @Mapping(target = "id.idCompra", ignore = true)
    @Mapping(target = "compra", ignore = true)
    @Mapping(target = "producto", ignore = true)
    CompraProducto toEntity(PurchaseItemDTO purchaseItemDto);
}
