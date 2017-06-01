package com.bliblifuture.service;

import com.bliblifuture.model.SKU;
import com.bliblifuture.repository.SKURepository;
import com.bliblifuture.repository.StockOpnameRepository;
import com.bliblifuture.repository.UpdateQuantityRepository;
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

        //ingat SKUid masih diset cara manual
        //newSKU.setSkuId(updateQuantityRequest.getSkuId());

        //SKU editedSKU = skuRepository.findByskuId(updateQuantityRequest.getSkuId());
        //editedSKU.setPhysicalQty(updateQuantityRequest.getPhysicalQty());
        //editedSKU.setInformation("COUNTED");
        //skuRepository.save(editedSKU);
    }

    public boolean updateStatus(UpdateQuantityRequest updateQuantityRequest) {

        String info = "";
        SKU skuYangDiUpdate = skuRepository.findByskuId(updateQuantityRequest.getSkuId());

        String reqQty = updateQuantityRequest.getPhysicalQty();
        int sistemkuantiti = skuYangDiUpdate.getSystemQty();
        int pisikalkuantiti = Integer.parseInt(updateQuantityRequest.getPhysicalQty());
        System.out.println("ini"+pisikalkuantiti);

        if (reqQty == null || reqQty.equals(""))
        {skuYangDiUpdate.setInformation("Belum dihitung");}
        else
            {
            if (sistemkuantiti - pisikalkuantiti < 0)
            {info = "Kurang";}
            else if (sistemkuantiti - pisikalkuantiti == 0)
            {info = "Sesuai";}
             else if (sistemkuantiti - pisikalkuantiti > 0)
            {info = "Kelebihan";}
            }

        skuYangDiUpdate.setPhysicalQty(pisikalkuantiti);
        skuYangDiUpdate.setInformation(info);
        skuRepository.save(skuYangDiUpdate);

        return true; //diasumsikan kalo udah sampe baris atasnya brarti udah dilakukakan saving
        }
    }

    //potensi human eror bsr muncul kalo pake if di dalam if dkk
