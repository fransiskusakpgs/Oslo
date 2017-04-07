package com.bliblifuture.configuration;

import com.bliblifuture.model.StockOpname;
import com.bliblifuture.model.WorkList;
import com.bliblifuture.repository.StockOpnameRepository;
import com.bliblifuture.repository.WorkListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DatabaseSeeder {
    @Autowired
    StockOpnameRepository stockOpnameRepo;
    @Autowired
    WorkListRepository workListRepo;

    @PostConstruct
    private void mockupData(){
//        StockOpname stockOpnameOne = new StockOpname();
//        stockOpnameOne.setSKU("ABAB");
//        stockOpnameRepo.save(stockOpnameOne);
//
//        StockOpname stockOpnameTwo = new StockOpname();
//        stockOpnameTwo.setSKU("BABA");
//        stockOpnameRepo.save(stockOpnameTwo);
//
//        StockOpname stockOpnameThree = new StockOpname();
//        stockOpnameThree.setSKU("CACA");
//        stockOpnameRepo.save(stockOpnameThree);

        WorkList workListOne = new WorkList();
        workListOne.setSKU("1A1A");
        workListRepo.save(workListOne);

    }
}
