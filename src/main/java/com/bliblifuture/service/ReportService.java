package com.bliblifuture.service;

import com.bliblifuture.model.Report;
import com.bliblifuture.model.StockOpname;
import com.bliblifuture.repository.ReportRepository;
import com.bliblifuture.repository.StockOpnameRepository;
import com.bliblifuture.request.ReportRequest;
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

    public Report findReportByDate(String request){
        Date date =  formatWaktu(request);
        Report data = reportRepo.findByDate(date);
        return data;
    }

    public void createReport(ReportRequest request){
        Report newReport = new Report();
        String date = request.getFinishCountingTime();
        Date convertedDate = formatWaktu(date);
        List<StockOpname> stockOpnames = stockOpnameRepo.findByFinishCountingTime(convertedDate);
        newReport.setStockOpnames(stockOpnames);
        newReport.countQty();
        newReport.countSKU();
        reportRepo.save(newReport);

    }

    public Date formatWaktu(String waktu){

        Date formatedDate = new Date();
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd hh:mm:ss");
            Date convertedDate = sdf.parse(waktu);
            formatedDate = convertedDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatedDate;
    }
}
