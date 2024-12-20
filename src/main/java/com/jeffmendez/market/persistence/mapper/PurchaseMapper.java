package com.jeffmendez.market.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.jeffmendez.market.domain.model.PurchaseDTO;
import com.jeffmendez.market.persistence.entity.Compra;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {
    
    @Mapping(source = "idCompra", target = "purchaseId")
    @Mapping(source = "idCliente", target = "clientId")
    @Mapping(source = "fecha", target = "date")
    @Mapping(source = "medioPago", target = "paymentMethod")
    @Mapping(source = "comentario", target = "comment")
    @Mapping(source = "estado", target = "state")
    @Mapping(source = "productos", target = "items")
    PurchaseDTO toDto(Compra compra);
    List<PurchaseDTO> toDtoPurchases(List<Compra> compras);

    @InheritInverseConfiguration
    @Mapping(target = "cliente", ignore = true)
    Compra toEntity(PurchaseDTO purchaseDto);
}
