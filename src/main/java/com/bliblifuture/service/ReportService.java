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

    public Report findReportByDate(String request){
        Date date =  formatWaktu(request);
        Report data = reportRepo.findByDate(date);
        return data;
    }

    public void createReport(ReportRequest request){
        Report newReport = new Report();

//        String date = request.getFinishCountingTime();
//        Date convertedDate = formatWaktu(date);
//        List<StockOpname> stockOpnames = stockOpnameRepo.findByFinishCountingTime(convertedDate);
//        LocalDateTime convertedDate = LocalDateTime.parse(date, DateTimeFormat.forPattern("yyyy/mm/dd hh:mm:ss"));
//        List<StockOpname> stockOpnames = stockOpnameRepo.findByStartCountingTime(convertedDate);
//        List<StockOpname> stockOpnames = stockOpnameRepo.findByStartCountingTimeBetween(convertedDate,)
//        for (StockOpname stockOpname: stockOpnames) {
//            stockOpname.setReport(newReport);
//            stockOpnameRepo.save(stockOpname);
//        }
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
        LocalDate newDate = LocalDate.parse(request.getReportDate(), DateTimeFormat.forPattern("yyyy/mm/dd"));
        List<StockOpname> stockOpnames = stockOpnameRepo.findByReportDate(newDate);
        newReport.setStockOpnames(stockOpnames);
        newReport.countQty();
        newReport.countSKU();
        reportRepo.save(newReport);

    }

    public LocalDate convertStringToLocalDate(String stringDate){
        LocalDate convertedDate = LocalDate.parse(stringDate, DateTimeFormat.forPattern("yyyy/mm/dd"));
        return convertedDate;
    }

    public boolean compareDate(Date date1, Date date2){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
        if(sdf.format(date1).equals(sdf.format(date2))){
            return true;
        }
        else{
            return false;
        }
    }

    public Date formatWaktu(String waktu){

        Date formatedDate = new Date();
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
            Date convertedDate = sdf.parse(waktu);
            formatedDate = convertedDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatedDate;
    }
}
