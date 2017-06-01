package com.bliblifuture.controller;

import com.bliblifuture.model.SKU;
import com.bliblifuture.request.SKURequest;
import com.bliblifuture.request.UpdateQuantityRequest;
import com.bliblifuture.response.BaseResponse;
import com.bliblifuture.response.ListResponse;
import com.bliblifuture.service.SKUService;
import com.bliblifuture.service.UpdateFinishTimeService;
import com.bliblifuture.service.UpdateQuantityService;
import com.bliblifuture.service.UpdateStartTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SKUController {
    @Autowired
    SKUService skuService;
    @Autowired
    UpdateQuantityService   updateQuantityService;
    @Autowired
    UpdateStartTimeService updateStartTimeService;
    @Autowired
    UpdateFinishTimeService updateFinishTimeService;

    @RequestMapping(value = "/api/SKUs", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse createSKU(@RequestBody SKURequest request) {
        skuService.createSKU(request);
        BaseResponse response = new BaseResponse(true,"");
        return response;
    }

    @RequestMapping(value = "/api/updatestatus" , method = RequestMethod.POST , consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse updateStatusDanQuantity(@RequestBody UpdateQuantityRequest   updateQuantityRequest){
        return new BaseResponse( updateQuantityService.updateStatus(updateQuantityRequest),""); //format coding paling hebat
    }

    @RequestMapping(value = "/api/SKUs" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public ListResponse<SKU> getAllDataSKU(@RequestParam String id) {
        List<SKU> data = skuService.findSKUByStockOpname(id);
        ListResponse<SKU> dataresponse2 = new ListResponse<>(true, "", data);
        return dataresponse2;
    }

    @RequestMapping(value = "/api/updatestarttimestockopname", method = RequestMethod.PUT )
    @ResponseBody
    public  BaseResponse updateStartTime(@RequestParam String id) {
        return new BaseResponse(updateStartTimeService.updateJam(id),"");
    }

    @RequestMapping(value = "/api/updatefinishtimestockopname", method = RequestMethod.PUT )
    @ResponseBody
    public  BaseResponse updateFinishTime(@RequestParam String id) {
        return new BaseResponse(updateFinishTimeService.updateJam(id),"");
    }
}