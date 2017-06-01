package com.bliblifuture.controller;

import com.bliblifuture.model.Report;
import com.bliblifuture.response.SingleResponse;
import com.bliblifuture.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
}
