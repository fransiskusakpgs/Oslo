package com.bliblifuture.controller;

import com.bliblifuture.model.StockOpname;
import com.bliblifuture.repository.StockOpnameRepository;
import com.bliblifuture.response.ListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    StockOpnameRepository stockOpnameRepo;

    @RequestMapping(value="/api/stockopnames", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ListResponse<StockOpname> getAllData() {
        List<StockOpname> data = stockOpnameRepo.findAll();
        ListResponse<StockOpname> response = new ListResponse<>(true, "", data);
        return response;
    }
}
