package com.bliblifuture.controller;

import com.bliblifuture.model.StockOpname;
import com.bliblifuture.request.SingleRequest;
import com.bliblifuture.request.StockOpnameRequest;
import com.bliblifuture.response.BaseResponse;
import com.bliblifuture.response.ListResponse;
import com.bliblifuture.response.SingleStockOpnameResponse;
import com.bliblifuture.response.StockOpnameResponse;
import com.bliblifuture.service.SKUService;
import com.bliblifuture.service.StockOpnameService;
import com.bliblifuture.service.UnknownSKUService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;



@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class StockOpnameController {
    @Autowired
    StockOpnameService stockOpnameService;

    @RequestMapping(value="/api/stockopname", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SingleStockOpnameResponse getSingleStockOpnameData(@RequestParam String id){
        StockOpnameResponse data = stockOpnameService.getStockopnameData(id);
        System.out.println("haloo");
        System.out.println(data.getStartCountingTime());
        SingleStockOpnameResponse response = new SingleStockOpnameResponse(true,"",data);
        return response;
    }

    @RequestMapping(value="/api/stockopnames", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ListResponse<StockOpnameResponse> getAllData() {
        List<StockOpname> data = stockOpnameService.findAll();

        List<StockOpnameResponse> responses = new ArrayList<StockOpnameResponse>();
        for (StockOpname stockOpname: data) {
            StockOpnameResponse response = new StockOpnameResponse();
            BeanUtils.copyProperties(stockOpname, response);
            if(stockOpname.getAssignedTo()== null){
                response.setAssignedTo("");
            }else{
                response.setAssignedTo(stockOpname.getAssignedTo().getUsername());
            }

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

    @RequestMapping(value = "/api/updatesto", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse updateStockOpname(@RequestBody String request) {
        stockOpnameService.updateStockOpnameStatus(request);
        BaseResponse response = new BaseResponse(true,"");
        return response;
    }



}
