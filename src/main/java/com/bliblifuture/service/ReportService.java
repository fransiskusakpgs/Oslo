package com.bliblifuture.service;

import com.bliblifuture.OsloConstanta;
import com.bliblifuture.model.Report;
import com.bliblifuture.model.StockOpname;
import com.bliblifuture.repository.ReportRepository;
import com.bliblifuture.repository.StockOpnameRepository;
import com.bliblifuture.request.ReportRequest;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Report findReportByDate(String date){
        LocalDate convertedDate = LocalDate.parse(date, DateTimeFormat.forPattern("yyyyMMdd"));
        Report data = reportRepo.findByDate(convertedDate);
        return data;
    }

    public void createReport(ReportRequest request) {
        LocalDate newDate = LocalDate.parse(request.getReportDate(), DateTimeFormat.forPattern(OsloConstanta.DATE_FORMAT));
        Report newReport = new Report();
        newReport.setDate(newDate);
        List<StockOpname> stockOpnames = stockOpnameRepo.findByReportDate(newDate);
        newReport.setStockOpnames(stockOpnames);
        reportRepo.save(newReport);
        newReport.countQty();
        newReport.countSKU();
        reportRepo.save(newReport);
    }
}
