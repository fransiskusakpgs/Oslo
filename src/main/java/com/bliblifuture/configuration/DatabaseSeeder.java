package com.bliblifuture.configuration;

import com.bliblifuture.model.StockOpname;
import com.bliblifuture.model.Warehouse;
import com.bliblifuture.repository.StockOpnameRepository;
import com.bliblifuture.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Component
public class DatabaseSeeder {
    @Autowired
    StockOpnameRepository stockOpnameRepo;
    @Autowired
    WarehouseRepository warehouseRepo;

    @PostConstruct
    private void mockupData(){
        StockOpname stockOpnameOne = new StockOpname();
        stockOpnameOne.setStockOpnameId("STO-001-1001");
        stockOpnameOne.setSKU("ABAB");
//      checkDate
        stockOpnameOne.formatWaktuPembuatan("2011/02/01 03:04:01");
        stockOpnameRepo.save(stockOpnameOne);

        StockOpname stockOpnameTwo = new StockOpname();
        stockOpnameTwo.setStockOpnameId("STO-002-1002");
        stockOpnameTwo.setSKU("BABA");
        stockOpnameRepo.save(stockOpnameTwo);

        StockOpname stockOpnameThree = new StockOpname();
        stockOpnameThree.setStockOpnameId("STO-003-1003");
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
