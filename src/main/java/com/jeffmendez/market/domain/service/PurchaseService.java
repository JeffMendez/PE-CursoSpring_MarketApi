package com.jeffmendez.market.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeffmendez.market.domain.model.PurchaseDTO;
import com.jeffmendez.market.domain.repository.PurchaseDTORepository;

import jakarta.transaction.Transactional;

@Service
public class PurchaseService {
    @Autowired PurchaseDTORepository purchaseDTORepository;

    public List<PurchaseDTO> getAll() {
        return purchaseDTORepository.getAll();
    }

    public Optional<List<PurchaseDTO>> getByClient(String clientId) {
        return purchaseDTORepository.getByClient(clientId);
    }

    @Transactional
    public PurchaseDTO save(PurchaseDTO purchase) {
        return purchaseDTORepository.save(purchase);
    }
}
