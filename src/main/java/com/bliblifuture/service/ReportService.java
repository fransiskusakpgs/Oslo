package com.bliblifuture.service;
import com.bliblifuture.model.Report;
import com.bliblifuture.model.StockOpname;
import com.bliblifuture.repository.ReportRepository;
import com.bliblifuture.repository.StockOpnameRepository;
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

    public Report findReportByDate(LocalDate date){
        Report data = reportRepo.findByDate(date);
        return data;
    }

    public Report createReport(LocalDate date) {
        Report newReport = new Report();
        newReport.setDate(date);
        List<StockOpname> stockOpnames = stockOpnameRepo.findByReportDate(date);
        newReport.setStockOpnames(stockOpnames);
        reportRepo.save(newReport);
        newReport.countQty();
        newReport.countSKU();
        reportRepo.saveAndFlush(newReport);
        return newReport;
    }

    public Report findOrCreateReportByDate(String date) throws IllegalArgumentException{
        LocalDate convertedDate = LocalDate.parse(date, DateTimeFormat.forPattern("yyyyMMdd"));
        if(convertedDate.isAfter( new LocalDate())||convertedDate.isEqual(new LocalDate())){
            throw new IllegalArgumentException("Please insert the date before today!");
        }
        Report report = findReportByDate(convertedDate);
        if(report == null){
            report = createReport(convertedDate);
        }
        return report;
    }
}
