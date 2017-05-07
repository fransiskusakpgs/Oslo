package com.bliblifuture.service;

import com.bliblifuture.model.SKU;
import com.bliblifuture.model.StockOpname;
import com.bliblifuture.repository.SKURepository;
import com.bliblifuture.repository.StockOpnameRepository;
import com.bliblifuture.request.SKURequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SKUService {
    @Autowired
    SKURepository SKUrepo;
    @Autowired
    StockOpnameRepository stockOpnameRepo;

    public List<SKU> findSKUByStockOpname(String id){ //data request udah dipassing disini

        StockOpname a = stockOpnameRepo.findByStockOpnameId(id);

        List<SKU> data12 = SKUrepo.findByStockOpname(a);

        return data12;
    }

    public void  createSKU(SKURequest skuRequest) {
        SKU newSKU = new SKU();
        newSKU.setSKUid("10");

        newSKU.setStockOpname(stockOpnameRepo.findByStockOpnameId("100"));
        newSKU.setStockType(skuRequest.getStockType());
        newSKU.setStorageCode(skuRequest.getStorageCode());
        newSKU.setItemName(skuRequest.getItemName());
        newSKU.setSystemQty(Integer.parseInt(skuRequest.getSystemQty()));
        SKUrepo.save(newSKU);

        //bikin sku
        //create new sku
        //masukkan data dari request ke sku yg barusan dibikin
        //.save new yg barusan
    }

}
