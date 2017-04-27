package com.bliblifuture.controller;

import com.bliblifuture.model.Report;
import com.bliblifuture.response.SingleResponse;
import com.bliblifuture.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ReportController {
    @Autowired
    ReportService reportService;

    @RequestMapping(value ="/api/reports", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SingleResponse findOrCreateReport(@RequestParam String date){
        Report data = reportService.findOrCreateReportByDate(date);
        SingleResponse response = new SingleResponse(true,"", data);
        return response;
    }

}
