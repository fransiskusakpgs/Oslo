package com.bliblifuture.service;

import com.bliblifuture.model.SKU;
import com.bliblifuture.model.StockOpname;
import com.bliblifuture.model.UnknownSKU;
import com.bliblifuture.repository.SKURepository;
import com.bliblifuture.repository.StockOpnameRepository;
import com.bliblifuture.repository.UnknownSKURepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SKUService {
    @Autowired
    SKURepository SKUrepo;
    @Autowired
    UnknownSKURepository UnknownSKUrepo;

    public List<SKU> findAll(){
        List<SKU> data11 = SKUrepo.findAll();
        return data11;
    }
    public List<UnknownSKU> findAll2(){
        List<UnknownSKU> data12 = UnknownSKUrepo.findAll();
        return data12;
    }


}
