package com.bliblifuture.service;
import com.bliblifuture.model.Report;
import com.bliblifuture.model.SKU;
import com.bliblifuture.model.StockOpname;
import com.bliblifuture.model.UnknownSKU;
import com.bliblifuture.repository.ReportRepository;
import com.bliblifuture.repository.SKURepository;
import com.bliblifuture.repository.StockOpnameRepository;
import com.bliblifuture.repository.UnknownSKURepository;
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
    @Autowired
    SKURepository skuRepo;
    @Autowired
    UnknownSKURepository unknownSKURepo;

    public Report findReportByDate(LocalDate date){
        Report data = reportRepo.findByDate(date);
        return data;
    }

    public Report createReport(LocalDate date) throws IllegalArgumentException {
        Report newReport = new Report();
        newReport.setDate(date);
        List<StockOpname> stockOpnames = stockOpnameRepo.findByReportDate(date);
        if(stockOpnames.size()==0){
            throw new IllegalArgumentException("Sorry, there are no stockopname done on " + date.toString());
        }
        newReport.setStockOpnames(stockOpnames);
        reportRepo.save(newReport);
        countingSKUandQty(newReport, stockOpnames);
//        newReport.countQty();
//        newReport.countSKU();
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

    public void countingSKUandQty(Report report, List<StockOpname> stockOpnames){
        int countedSKU = 0;
        int uncountedSKU = 0;
        int totalUnknownQty = 0;
        int totalUnknownSKU = 0;
        int countedQty = 0;
        int deficitQty = 0;
        int surplusQty = 0;
        int deficitSKU = 0;
        int surplusSKU = 0;
        for (StockOpname stockOpname: stockOpnames) {
            List<SKU> skus = skuRepo.findByStockOpname(stockOpname);
            List<UnknownSKU> unknownSKUs = unknownSKURepo.findByStockOpname(stockOpname);
            for (SKU sku: skus) {
                String status = sku.getInformation();
                if (status.equals("COUNTED")){
                    countedSKU++;
                    countedQty += sku.getPhysicalQty();
                    int sistemQty = sku.getSystemQty();
                    int fisikQty = sku.getPhysicalQty();
                    int selisih = sistemQty-fisikQty;

                    if (selisih>0){
                        deficitQty += Math.abs(selisih);
                        deficitSKU++;
                    } else if (selisih < 0) {
                        surplusQty += selisih;
                        surplusSKU++;
                    }
                }
                else{
                    uncountedSKU++;
                }
            }

            for (UnknownSKU unknownSKU: unknownSKUs) {
                totalUnknownQty += unknownSKU.getPhysicalQty();
                totalUnknownSKU++;
            }
        }

        report.setCountedSKU(countedSKU);
        report.setCountedQty(countedQty);
        report.setTotalUnknownQty(totalUnknownQty);
        report.setTotalUnknownSKU(totalUnknownSKU);
        report.setDeficitQty(deficitQty);
        report.setDeficitSKU(deficitSKU);
        report.setSurplusQty(surplusQty);
        report.setSurplusSKU(surplusSKU);
    }
}
