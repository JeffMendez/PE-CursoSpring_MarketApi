package com.jeffmendez.market.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeffmendez.market.domain.model.PurchaseDTO;
import com.jeffmendez.market.domain.service.PurchaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    
    @Autowired PurchaseService purchaseService;

    @GetMapping()
    public ResponseEntity<List<PurchaseDTO>> getAll() {
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    }
    
    @GetMapping("/client/{id}")
    public ResponseEntity<List<PurchaseDTO>> getByClient(@PathVariable("id") String clientId) {
        return purchaseService.getByClient(clientId)
                .map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<PurchaseDTO> save(@RequestBody PurchaseDTO purchase) {
        return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
    }
}
