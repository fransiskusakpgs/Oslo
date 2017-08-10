package com.bliblifuture.controller;

import com.bliblifuture.OsloConstanta;
import com.bliblifuture.model.Report;
import com.bliblifuture.model.StockOpname;
import com.bliblifuture.response.ListResponse;
import com.bliblifuture.response.SingleResponse;
import com.bliblifuture.service.ReportService;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class ReportController {
    @Autowired
    ReportService reportService;

    @RequestMapping(value ="/api/reports", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SingleResponse findOrCreateReport(@RequestParam String date){
        try {
            Report data = reportService.findOrCreateReportByDate(date);
            return new SingleResponse(true,"", data);
        } catch (IllegalArgumentException e){
            return new SingleResponse(false,e.getMessage(), null);
        }
    }

    @RequestMapping(value = "/api/SKUreport", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ListResponse findAllReportSKU(@RequestParam String date) {
        LocalDate convertedDate = LocalDate.parse(date, DateTimeFormat.forPattern(OsloConstanta.DATE_FORMAT));
        List<StockOpname> data2 = new ArrayList<>(reportService.getStockopnameReport(convertedDate));
        return new ListResponse(true,"" , data2);
    }
}
