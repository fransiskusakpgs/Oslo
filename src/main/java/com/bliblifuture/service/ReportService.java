package com.bliblifuture.service;

import com.bliblifuture.model.Report;
import com.bliblifuture.model.StockOpname;
import com.bliblifuture.repository.ReportRepository;
import com.bliblifuture.repository.StockOpnameRepository;
import com.bliblifuture.request.ReportRequest;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    ReportRepository reportRepo;
    @Autowired
    StockOpnameRepository stockOpnameRepo;

    public List<Report> findAllReport(){
        List<Report> data = reportRepo.findAll();
        return data;
    }

    public void createReport(ReportRequest request) {
        LocalDate newDate = LocalDate.parse(request.getReportDate(), DateTimeFormat.forPattern("yyyy-mm-dd"));
        Report newReport = new Report();
        newReport.setDate(request.getReportDate());
        List<StockOpname> stockOpnames = stockOpnameRepo.findByReportDate(newDate);
        System.out.println("inilho"+stockOpnames.size());
        newReport.setStockOpnames(stockOpnames);
        reportRepo.save(newReport);
        newReport.countQty();
        newReport.countSKU();
        reportRepo.save(newReport);
    }
}
