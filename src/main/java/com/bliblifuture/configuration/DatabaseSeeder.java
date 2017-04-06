package com.bliblifuture.configuration;

import com.bliblifuture.model.StockOpname;
import com.bliblifuture.model.Warehouse;
import com.bliblifuture.repository.StockOpnameRepository;
import com.bliblifuture.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DatabaseSeeder {
    @Autowired
    StockOpnameRepository stockOpnameRepo;
    @Autowired
    WarehouseRepository warehouseRepo;

    @PostConstruct
    private void mockupData(){
        StockOpname stockOpnameOne = new StockOpname();
        stockOpnameOne.setSKU("ABAB");
        stockOpnameRepo.save(stockOpnameOne);

        StockOpname stockOpnameTwo = new StockOpname();
        stockOpnameTwo.setSKU("BABA");
        stockOpnameRepo.save(stockOpnameTwo);

        StockOpname stockOpnameThree = new StockOpname();
        stockOpnameThree.setSKU("CACA");
        stockOpnameRepo.save(stockOpnameThree);

        Warehouse warehouseOne = new Warehouse();
        warehouseOne.setName("Cawang");
        warehouseRepo.save(warehouseOne);

        Warehouse warehouseTwo = new Warehouse();
        warehouseTwo.setName("Cakung");
        warehouseRepo.save(warehouseTwo);

        Warehouse warehouseThree = new Warehouse();
        warehouseThree.setName("Gudang KS Tubun");
        warehouseRepo.save(warehouseThree);

    }
}
