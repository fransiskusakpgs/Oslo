package com.bliblifuture.service;

import com.bliblifuture.model.Warehouse;
import com.bliblifuture.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseService {

    @Autowired
    WarehouseRepository warehouseRepo;
    public List<Warehouse> findAll(){
        List<Warehouse> data = warehouseRepo.findAll();
        return data;
    }

}
