package com.bliblifuture.controller;

import com.bliblifuture.request.AssignmentRequest;
import com.bliblifuture.response.BaseResponse;
import com.bliblifuture.service.StockOpnameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AssignmentController {
    @Autowired
    StockOpnameService stockOpnameService;

    @RequestMapping(value = "api/assignment", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse assignStockOpname(@RequestBody AssignmentRequest request){
        stockOpnameService.assignStockOpname(request);
        BaseResponse response = new BaseResponse(true,"");
        return response;
    }

    @RequestMapping(value = "/api/assignments", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse unAssignStockOpname(@RequestBody AssignmentRequest request){
        stockOpnameService.unAssignStockOpname(request);
        BaseResponse response = new BaseResponse(true,"");
        return response;
    }

}
