package com.bliblifuture.controller;

import com.bliblifuture.model.StockOpname;
import com.bliblifuture.request.StockOpnameRequest;
import com.bliblifuture.response.BaseResponse;
import com.bliblifuture.response.ListResponse;
import com.bliblifuture.response.StockOpnameResponse;
import com.bliblifuture.service.SKUService;
import com.bliblifuture.service.StockOpnameService;
import com.bliblifuture.service.UnknownSKUService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;



@Controller
public class StockOpnameController {
    @Autowired
    StockOpnameService stockOpnameService;

    @RequestMapping(value="/api/stockopnames", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ListResponse<StockOpnameResponse> getAllData() {
        List<StockOpname> data = stockOpnameService.findAll();

        //
        List<StockOpnameResponse> responses = new ArrayList<StockOpnameResponse>();
        for (StockOpname stockOpname: data) {
            StockOpnameResponse response = new StockOpnameResponse();
            BeanUtils.copyProperties(stockOpname, response);
            response.setWaktuPembuatan(stockOpname.getWaktuPembuatan().toDate());
            responses.add(response);
        }
        //

        ListResponse<StockOpnameResponse> response = new ListResponse<>(true, "", responses);
        return response;
    }

    @RequestMapping(value = "/api/stockopnames", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse createStockOpnames(@RequestBody StockOpnameRequest request) {
        stockOpnameService.createStockOpname(request);
        BaseResponse response = new BaseResponse(true,"");
        return response;
    }

}
