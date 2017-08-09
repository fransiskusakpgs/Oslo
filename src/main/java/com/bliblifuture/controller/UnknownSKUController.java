package com.bliblifuture.controller;

import com.bliblifuture.model.UnknownSKU;
import com.bliblifuture.request.UnknownSKURequest;
import com.bliblifuture.response.BaseResponse;
import com.bliblifuture.response.ListResponse;
import com.bliblifuture.service.UnknownSKUService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class UnknownSKUController {

    @Autowired
    UnknownSKUService unknownSKUService;

    @RequestMapping(value = "/api/unknownSKUs1", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BaseResponse addUnknownSKU(@RequestBody UnknownSKURequest request) {
        System.out.println("frannnnnnnnnnnns"+ request.getUnknownSKUid());
        unknownSKUService.addUnknownSKUtoList(request);
        BaseResponse responseBS = new BaseResponse(true,"");
        return responseBS;
    }

    @RequestMapping( value = "/api/unknownSKUs1" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ListResponse<UnknownSKU> getAllDataUnknownSKU(@RequestParam String id) {
        List<UnknownSKU> data = unknownSKUService.findUnknownSKUByStockOpname(id); //sampe returndata12
        ListResponse<UnknownSKU> dataresponse = new ListResponse<>( true, "", data );
        return dataresponse;
    }
}
