package com.bliblifuture.service;

import com.bliblifuture.model.SKU;
import com.bliblifuture.model.StockOpname;
import com.bliblifuture.repository.SKURepository;
import com.bliblifuture.repository.StockOpnameRepository;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.joda.JodaDateTimeFormatAnnotationFormatterFactory;
import org.springframework.stereotype.Service;

@Service

public class UpdateStartTimeService {
    @Autowired
    SKURepository skuRepository;

    @Autowired
    StockOpnameRepository stockOpnameRepository;

    public boolean updateJam(String id) {
        StockOpname stockOpnameYgDiUpdate =stockOpnameRepository.findByStockOpnameId(id);
        LocalDateTime jamstart = new LocalDateTime();

        stockOpnameYgDiUpdate.setStartCountingTime(jamstart);

    return true;
    }


    }

