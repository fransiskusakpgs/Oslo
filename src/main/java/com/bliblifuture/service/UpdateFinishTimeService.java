package com.bliblifuture.service;

import com.bliblifuture.model.StockOpname;
import com.bliblifuture.repository.SKURepository;
import com.bliblifuture.repository.StockOpnameRepository;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UpdateFinishTimeService {
    @Autowired
    SKURepository skuRepository;
    @Autowired
    StockOpnameRepository stockOpnameRepository;

    public boolean updateJam(String id) {
        StockOpname stockOpnameYgDiUpdate =stockOpnameRepository.findByStockOpnameId(id);
        LocalDateTime jamfinish = new LocalDateTime();

        stockOpnameYgDiUpdate.setStartCountingTime(jamfinish);
    return true;
    }
}

