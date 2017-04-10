package com.bliblifuture.controller;

import com.bliblifuture.model.SKU;
import com.bliblifuture.model.StockOpname;
import com.bliblifuture.model.UnknownSKU;
import com.bliblifuture.repository.SKURepository;
import com.bliblifuture.repository.StockOpnameRepository;
import com.bliblifuture.repository.UnknownSKURepository;
import com.bliblifuture.repository.WorkListRepository;
import com.bliblifuture.request.StockOpnameRequest;
import com.bliblifuture.response.*;

import com.bliblifuture.service.SKUService;
import com.bliblifuture.service.StockOpnameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    StockOpnameRepository stockOpnameRepo;
    @Autowired
    WorkListRepository workListRepo;

    @Autowired
    StockOpnameService stockOpnameService;

    @Autowired
    SKUService skuService;

    @RequestMapping(value="/api/stockopnames", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ListResponse<StockOpname> getAllData() {
        List<StockOpname> data = stockOpnameService.findAll();
        ListResponse<StockOpname> response = new ListResponse<>(true, "", data);
        return response;
    }

//    @RequestMapping(value = "/api/SKUs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public DoubleResponse<SKU> getAllData112() {
//        List <SKU> data = skuService.findAll();
//        List <UnknownSKU> data2 = skuService.findAll2();
//
//        DoubleResponse<SKU> response33 = new DoubleResponse<>(true,"",data,data2);
//        return response33;
//    }


//    @RequestMapping(value = "/api/worklists", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public WorkListResponses getAllData2() {
//        WorkListResponses response2 = new WorkListResponses();
//        response2.setDataworklist(workListRepo.findAll());
//        return response2;
//    }


@RequestMapping(value = "api/stockopnames", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse createStockOpnames(@RequestBody StockOpnameRequest request) {
    stockOpnameService.createStockOpname(request);
    BaseResponse response = new BaseResponse(true,"");
    return response;

}
}
