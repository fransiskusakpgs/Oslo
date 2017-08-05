package com.bliblifuture.controller;

import com.bliblifuture.request.AssignmentRequest;
import com.bliblifuture.response.BaseResponse;
import com.bliblifuture.service.StockOpnameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class AssignmentController {
    @Autowired
    StockOpnameService stockOpnameService;

    @RequestMapping(value = "api/assignments", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse assignStockOpname(@RequestBody AssignmentRequest request){
        try{
            Boolean success = stockOpnameService.assignStockOpname(request);
            return  new BaseResponse(success,"");
        } catch (IllegalArgumentException e){
            return new BaseResponse(false, e.getMessage());
        }
    }

    @RequestMapping(value = "/api/assignments", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse unAssignStockOpname(@RequestBody AssignmentRequest request){
        try{
            Boolean success = stockOpnameService.unAssignStockOpname(request);
            return new BaseResponse(success,"");
        }catch (IllegalArgumentException e){
            return new BaseResponse(false,e.getMessage());
        }
    }

}
