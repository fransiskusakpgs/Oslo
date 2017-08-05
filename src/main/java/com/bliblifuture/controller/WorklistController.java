package com.bliblifuture.controller;

import com.bliblifuture.model.Counter;
import com.bliblifuture.model.StockOpname;
import com.bliblifuture.response.ListResponse;
import com.bliblifuture.service.WorklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class WorklistController {
    @Autowired
    WorklistService worklistService;
//hapus aja baris ini
    @RequestMapping(value = "/api/worklist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ListResponse<StockOpname> getAllStockOpnameWorklist() {
        List<StockOpname> data = worklistService.findStockOpnameByAssignedTo();
        ListResponse<StockOpname> dataresponse2 = new ListResponse<>(true, "", data);
        return dataresponse2;
    }
}
