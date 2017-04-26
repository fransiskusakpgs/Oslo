package com.bliblifuture.controller;
import com.bliblifuture.model.SKU;
import com.bliblifuture.model.StockOpname;
import com.bliblifuture.model.UnknownSKU;
import com.bliblifuture.repository.SKURepository;
import com.bliblifuture.repository.StockOpnameRepository;
import com.bliblifuture.repository.UnknownSKURepository;
import com.bliblifuture.repository.WorkListRepository;
import com.bliblifuture.request.SKURequest;
import com.bliblifuture.request.SingleRequest;
import com.bliblifuture.request.StockOpnameRequest;
import com.bliblifuture.request.UnknownSKURequest;
import com.bliblifuture.response.*;

import com.bliblifuture.service.SKUService;
import com.bliblifuture.service.StockOpnameService;
import com.bliblifuture.service.UnknownSKUService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    UnknownSKUService unknownSKUService;

    @RequestMapping(value="/api/stockopnames", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ListResponse<StockOpname> getAllData() {
        List<StockOpname> data = stockOpnameService.findAll();
        ListResponse<StockOpname> response = new ListResponse<>(true, "", data);
        return response;
    }
//
//    @RequestMapping( value = "api/unknownSKUs", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public ListResponse<UnknownSKU> getAllDataUnknownSKU(@RequestBody SingleRequest request) {
//        List<UnknownSKU> data = unknownSKUService.findUnknownSKUByStockOpname(request); //sampe returndata12
//
//        ListResponse<UnknownSKU> dataresponse = new ListResponse<>( true, "", data );
//        return dataresponse;
//    }

    @RequestMapping( value = "api/unknownSKUs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ListResponse<UnknownSKU> getAllDataUnknownSKU(@RequestParam String id) {
        List<UnknownSKU> data = unknownSKUService.findUnknownSKUByStockOpname(id); //sampe returndata12
        ListResponse<UnknownSKU> dataresponse = new ListResponse<>( true, "", data );
        return dataresponse;
    }


    @RequestMapping(value = "api/SKUs" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public ListResponse<SKU> getAllDataSKU(@RequestParam String id) {

        List<SKU> data = skuService.findSKUByStockOpname(id);
        ListResponse<SKU> dataresponse2 = new ListResponse<>(true, "", data);
        return dataresponse2;


    }


@RequestMapping(value = "api/stockopnames", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse createStockOpnames(@RequestBody StockOpnameRequest request) {
    stockOpnameService.createStockOpname(request);
    BaseResponse response = new BaseResponse(true,"");
    return response;
}

    @RequestMapping(value = "api/SKUs", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse createSKU(@RequestBody SKURequest request) {
        skuService.createSKU(request);
        BaseResponse response = new BaseResponse(true,"");
        return response;
    }


    @RequestMapping(value = "api/unknownSKUs", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse addUnknownSKU(@RequestBody UnknownSKURequest request) {
        stockOpnameService.addUnknownSKUtoList(request);
        BaseResponse responseBS = new BaseResponse(true,"");
        return responseBS;
    }



}
