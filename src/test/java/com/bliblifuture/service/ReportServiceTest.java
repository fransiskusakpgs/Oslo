package com.bliblifuture.service;

import com.bliblifuture.OsloConstanta;
import com.bliblifuture.OsloUtils;
import com.bliblifuture.model.Report;
import com.bliblifuture.model.SKU;
import com.bliblifuture.model.StockOpname;
import com.bliblifuture.model.UnknownSKU;
import com.bliblifuture.repository.ReportRepository;
import com.bliblifuture.repository.StockOpnameRepository;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import javax.persistence.ManyToOne;

import java.util.ArrayList;
import java.util.List;

import static com.jayway.restassured.RestAssured.given;

public class ReportServiceTest {
    @InjectMocks
    private  ReportService reportService;


    @Mock
    private ReportRepository reportRepository;
    @Mock
    private StockOpnameRepository stockOpnameRepository;

    // Deklarasi variabel yang dibutuhkan
    SKU sku1 = new SKU();
    SKU sku2 = new SKU();
    SKU sku3 = new SKU();
    List<SKU> skus1 = new ArrayList<>();
    List<SKU> skus2 = new ArrayList<>();
    UnknownSKU unknownSKU1 = new UnknownSKU();
    List<UnknownSKU> unknownSKUS = new ArrayList<>();
    LocalDate convertedDate = LocalDate.parse("2017-01-01", DateTimeFormat.forPattern("yyyy-MM-dd"));
    StockOpname stockOpname1 = new StockOpname();
    StockOpname stockOpname2 = new StockOpname();
    List<StockOpname> stockOpnameList = new ArrayList<>();
    Report report = new Report();

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        sku1.setSKUid("SKU-01-01");
        sku1.setItemName("Buku");
        sku1.setStorageCode("A-01");
        sku1.setSystemQty(10);
        sku1.setPhysicalQty(10);
        sku1.setDeviationQty(0);
        sku1.setInformation("COUNTED");

        sku2.setSKUid("SKU-01-02");
        sku2.setItemName("Buku");
        sku2.setStorageCode("A-01");
        sku2.setSystemQty(10);
        sku2.setPhysicalQty(5);
        sku2.setDeviationQty(5);
        sku2.setInformation("COUNTED");

        sku3.setSKUid("SKU-01-03");
        sku3.setItemName("Buku");
        sku3.setStorageCode("A-01");
        sku3.setSystemQty(10);
        sku3.setPhysicalQty(5);
        sku3.setDeviationQty(5);
        sku3.setInformation("COUNTED");

        skus1.add(sku1);
        skus1.add(sku2);

        skus2.add(sku3);

        unknownSKU1.setUnknownSKUId("SKU-01-04");
        unknownSKU1.setStorageCode("A-01");
        unknownSKU1.setPhysicalQty(2);

        unknownSKUS.add(unknownSKU1);

        stockOpname1.setStockOpnameId("STO-01-01");
        stockOpname1.setStatus("FINISH COUNTING");
        stockOpname1.setReportDate(convertedDate);
        stockOpname1.setSKUs(skus1);
        stockOpname1.setUnknownSKUs(unknownSKUS);

        stockOpname2.setStockOpnameId("STO-01-02");
        stockOpname2.setStatus("FINISH COUNTING");
        stockOpname2.setReportDate(convertedDate);
        stockOpname2.setSKUs(skus2);

        stockOpnameList.add(stockOpname1);
        stockOpnameList.add(stockOpname2);

        report.setDate(convertedDate);
        report.setStockOpnames(stockOpnameList);
        report.countSKU();
        report.countQty();
    }

    @After
    public void tearDown(){
        Mockito.verifyNoMoreInteractions(this.reportRepository);
        Mockito.verifyNoMoreInteractions(this.stockOpnameRepository);
    }


    @Test
    public void findReportByDateTest() {
        // Given
        BDDMockito.given(this.reportRepository.findByDate(convertedDate)).willReturn(report);

        // When
        Report result = reportService.findReportByDate(convertedDate);

        // Then
        Assert.assertEquals(report, result);

        // Verify
        Mockito.verify(this.reportRepository, Mockito.times(1)).findByDate(convertedDate);

    }

    @Test
    public void createReportTest(){
        // Given
        BDDMockito.given(this.stockOpnameRepository.findByReportDate(convertedDate))
                .willReturn(stockOpnameList);

        // When
        Report result = reportService.createReport(convertedDate);
        System.out.println("report"+report);
        System.out.println("result"+result);
        //Then
        Assert.assertEquals(report,result);
        // Verify
        Mockito.verify(this.stockOpnameRepository, Mockito.times(1)).findByReportDate(convertedDate);
        Mockito.verify(this.reportRepository, Mockito.times(1)).save(report);
        Mockito.verify(this.reportRepository, Mockito.times(1)).saveAndFlush(report);

    }
//    public Report createReport(LocalDate date) {
//        Report newReport = new Report();
//        newReport.setDate(date);
//        List<StockOpname> stockOpnames = stockOpnameRepo.findByReportDate(date);
//        newReport.setStockOpnames(stockOpnames);
//        reportRepo.save(newReport);
//        newReport.countQty();
//        newReport.countSKU();
//        reportRepo.saveAndFlush(newReport);
//        return newReport;
//    }


//    @Test
//    public void findOrCreateReport(){
//        // Given
//        String stringDate = "20170101";
//
//        LocalDate convertedDate = LocalDate.parse("2017-01-01", DateTimeFormat.forPattern("yyyy-MM-dd"));
//        Report report = new Report();
//        report.setDate(convertedDate);
//
//        // When
//        Report result = reportService.findOrCreateReportByDate(stringDate);
//
//        // Then
//        Assert.assertEquals(report, result);
//
//        // Verify
//        Mockito.verify(this.reportRepository, Mockito.times(1)).findByDate(convertedDate);

//        public Report findOrCreateReportByDate(String date){
//            LocalDate convertedDate = LocalDate.parse(date, DateTimeFormat.forPattern("yyyyMMdd"));
//            Report report = findReportByDate(convertedDate);
//            if(report == null){
//                report = createReport(convertedDate);
//            }
//            return report;
//        }


}
