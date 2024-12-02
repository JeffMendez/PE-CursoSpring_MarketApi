package com.jeffmendez.market.domain.repository;

import java.util.List;
import java.util.Optional;

import com.jeffmendez.market.domain.model.PurchaseDTO;

public interface PurchaseDTORepository {
    List<PurchaseDTO> getAll();
    Optional<List<PurchaseDTO>> getByClient(String clientId);
    PurchaseDTO save(PurchaseDTO purchase);
}
