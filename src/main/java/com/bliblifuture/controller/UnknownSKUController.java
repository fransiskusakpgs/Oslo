package com.bliblifuture.controller;

import com.bliblifuture.model.UnknownSKU;
import com.bliblifuture.repository.StockOpnameRepository;
import com.bliblifuture.repository.WorkListRepository;
import com.bliblifuture.request.UnknownSKURequest;
import com.bliblifuture.response.BaseResponse;
import com.bliblifuture.response.ListResponse;
import com.bliblifuture.service.SKUService;
import com.bliblifuture.service.StockOpnameService;
import com.bliblifuture.service.UnknownSKUService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class UnknownSKUController {

    @Autowired
    UnknownSKUService unknownSKUService;

    @RequestMapping(value = "api/unknownSKUs", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse addUnknownSKU(@RequestBody UnknownSKURequest request) {
        unknownSKUService.addUnknownSKUtoList(request);
        BaseResponse responseBS = new BaseResponse(true,"");
        return responseBS;
    }

    @RequestMapping( value = "api/unknownSKUs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ListResponse<UnknownSKU> getAllDataUnknownSKU(@RequestParam String id) {
        List<UnknownSKU> data = unknownSKUService.findUnknownSKUByStockOpname(id); //sampe returndata12
        ListResponse<UnknownSKU> dataresponse = new ListResponse<>( true, "", data );
        return dataresponse;
    }

}
