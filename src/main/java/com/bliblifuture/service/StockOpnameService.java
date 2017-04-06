package com.bliblifuture.service;

import com.bliblifuture.model.StockOpname;
import com.bliblifuture.repository.StockOpnameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockOpnameService {
    @Autowired
    StockOpnameRepository stockOpnameRepo;
    public List<StockOpname> findAll(){
        List<StockOpname> data = stockOpnameRepo.findAll();
        return data;
    }

}
