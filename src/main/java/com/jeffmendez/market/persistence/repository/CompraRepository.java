package com.jeffmendez.market.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jeffmendez.market.domain.model.PurchaseDTO;
import com.jeffmendez.market.domain.repository.PurchaseDTORepository;
import com.jeffmendez.market.persistence.crud.CompraCrudRepository;
import com.jeffmendez.market.persistence.entity.Compra;
import com.jeffmendez.market.persistence.mapper.PurchaseMapper;

@Repository
public class CompraRepository implements PurchaseDTORepository {
    @Autowired private CompraCrudRepository compraCrudRepository;
    @Autowired private PurchaseMapper mapper;

    @Override
    public List<PurchaseDTO> getAll() {
        return mapper.toDtoPurchases((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<PurchaseDTO>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId)
            .map(compras -> mapper.toDtoPurchases(compras));
    }

    @Override
    public PurchaseDTO save(PurchaseDTO purchase) {
        Compra compra = mapper.toEntity(purchase);
        compra.setIdCompra(null);
        compra.getProductos().forEach(producto -> {
            producto.setCompra(compra);
        });

        return mapper.toDto(compraCrudRepository.save(compra));
    }
    
}
