package com.bliblifuture.service;

import com.bliblifuture.model.SKU;
import com.bliblifuture.model.StockOpname;
import com.bliblifuture.repository.SKURepository;
import com.bliblifuture.repository.StockOpnameRepository;
import com.bliblifuture.request.SKUMainRequest;
import com.bliblifuture.request.SKURequest;
import com.bliblifuture.response.SKUresponse;
import org.springframework.beans.BeanUtils;
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
        newSKU.setSkuId("10");

        newSKU.setStockOpname(stockOpnameRepo.findByStockOpnameId("100"));
        newSKU.setStockType(skuRequest.getStockType());
        newSKU.setStorageCode(skuRequest.getStorageCode());
        newSKU.setItemName(skuRequest.getItemName());
        newSKU.setSystemQty(Integer.parseInt(skuRequest.getSystemQty()));
        SKUrepo.save(newSKU);
    }

    public SKUresponse getSKUdata(String skuId){
        SKUresponse skUresponse = new SKUresponse();
        SKU sku = SKUrepo.findByskuId(skuId);
        BeanUtils.copyProperties(sku, skUresponse);
        return skUresponse;
    }

    public boolean inputByStorageCheckSKU(SKUMainRequest request){
        boolean checkSKUinSTO = false;
        List<SKU> skus = SKUrepo.findByStockOpname(stockOpnameRepo.findByStockOpnameId(request.getStoId()));
        for (SKU sku:skus) {
            if (sku.getSkuId().equals(request.getSkuId())) {
                checkSKUinSTO = true;
            }
        }
        return checkSKUinSTO;
    }

    public boolean inputByStorageCheckStorageCode(SKUMainRequest request){
        boolean checkSKUinStorage = false;
        if(SKUrepo.findByskuId(request.getSkuId()).getStorageCode().equals(request.getStorageCode())){
            checkSKUinStorage = true;
        }
        return checkSKUinStorage;
    }


}
