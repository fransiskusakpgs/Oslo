package com.bliblifuture.service;

import com.bliblifuture.model.SKU;
import com.bliblifuture.model.StockOpname;
import com.bliblifuture.repository.SKURepository;
import com.bliblifuture.repository.StockOpnameRepository;
import com.bliblifuture.repository.UpdateQuantityRepository;
import com.bliblifuture.request.SKURequest;
import com.bliblifuture.request.UpdateQuantityRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class UpdateQuantityService {
    @Autowired
    SKURepository skuRepository;
    @Autowired
    UpdateQuantityRepository updateQuantityRepository;
    @Autowired
    StockOpnameRepository stockOpnameRepository;

    public void updateQuantity(UpdateQuantityRequest updateQuantityRequest) {
        SKU newSKU = new SKU();
        newSKU.setSKUid("10");
        skuRepository.save(newSKU);
        newSKU.setPhysicalQty(updateQuantityRequest.getPhysicalQty());
        skuRepository.save(newSKU);
    }
}

