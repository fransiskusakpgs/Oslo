package com.bliblifuture.controller;

import com.bliblifuture.model.Counter;
import com.bliblifuture.model.StockOpname;
import com.bliblifuture.response.ListResponse;
import com.bliblifuture.service.WorklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller

public class WorklistController {
    @Autowired
    WorklistService worklistService;

    @RequestMapping(value = "/api/worklist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ListResponse<StockOpname> getAllStockOpnameWorklist(@RequestParam String username) {
        List<StockOpname> data = worklistService.findStockOpnameByAssignedTo(username);
        ListResponse<StockOpname> dataresponse2 = new ListResponse<>(true, "", data);
        return dataresponse2;
    }
}
