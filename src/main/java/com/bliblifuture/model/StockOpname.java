    package com.bliblifuture.model;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="stockOpname")
public class StockOpname {
    @Id
    private String stockOpnameId;
    private LocalDate waktuPembuatan;
    private String Status;
    private LocalDateTime startCountingTime;
    private LocalDateTime finishCountingTime;
    private LocalDate reportDate;
    private int totalQty;
    private int totalSKU;

    @OneToMany
    private List<SKU> SKUs = new ArrayList<>();
    @OneToMany
    private List<UnknownSKU> unknownSKUs = new ArrayList<>();
    @ManyToOne
    private Counter assignedTo;
    @ManyToOne
    private Report report;

    public void countTotalSKU() {
        totalSKU = SKUs.size();
    }
  
    public void countTotalQty(){
        int total = 0;
        for (SKU sku: SKUs) {
            total = total + sku.getSystemQty();
        }
        this.totalQty = total;
    }

    public void unAssignStockOpname(){
        this.assignedTo = null;
    }

    public void updateStatus(){
        if (!(assignedTo == null)){
            this.setStatus("ASSIGNED");
        }
        else if(!(startCountingTime == null)){
            this.setStatus("IN PROGRESS");
        }
        else if(!(finishCountingTime == null)){
            this.setStatus("FINISH COUNTING");
        }
        else{
            this.setStatus("OPEN");
        }
    }


    public void addUnknownSKU(UnknownSKU unknownSKU){
        this.unknownSKUs.add(unknownSKU);
    }

    public void startCounting(){
        LocalDateTime  currentTime = new LocalDateTime();
        this.startCountingTime = currentTime;
        updateStatus();
    }

    public void endCounting(){
        LocalDateTime currentTime = new LocalDateTime();
        this.finishCountingTime = currentTime;
        updateStatus();
    }

    public void reporting(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        String stringDate = sdf.format(date);
        setStringReportDate(stringDate);
    }

    public LocalDateTime getStartCountingTime() {
        return startCountingTime;
    }

    public void setStartCountingTime(LocalDateTime startCountingTime) {
        this.startCountingTime = startCountingTime;
    }

    public LocalDateTime getFinishCountingTime() {
        return finishCountingTime;
    }

    public void setFinishCountingTime(LocalDateTime finishCountingTime) {
        this.finishCountingTime = finishCountingTime;
    }

    public String getStockOpnameId() {
        return stockOpnameId;
    }

    public void setStockOpnameId(String stockOpnameId) {
        this.stockOpnameId = stockOpnameId;
    }

    public Counter getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Counter assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public LocalDate getWaktuPembuatan() {
        return waktuPembuatan;
    }

    public void setWaktuPembuatan(LocalDate waktuPembuatan) {
        this.waktuPembuatan = waktuPembuatan;
    }

    public void setStringWaktuPembuatan(String stringWaktuPembuatan){
        this.waktuPembuatan = convertStringToLocalDate(stringWaktuPembuatan);
    }

    public List<SKU> getSKUs() {
        return SKUs;
    }

    public void setSKUs(List<SKU> SKUs) {
        this.SKUs = SKUs;
    }

    public void addSKU(SKU sku){
        this.SKUs.add(sku);
    }

    public List<UnknownSKU> getUnknownSKUs() {
        return unknownSKUs;
    }

    public void setUnknownSKUs(List<UnknownSKU> unknownSKUs) {
        this.unknownSKUs = unknownSKUs;
    }

    public int getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(int totalQty) {
        this.totalQty = totalQty;
    }
    
    public int getTotalSKU() {
        return totalSKU;
    }

    public void setTotalSKU(int totalSKU ) {
        this.totalSKU = totalSKU;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDate reportDate) {
        this.reportDate = reportDate;
    }

    public void setStringReportDate(String stringReportDate){
       LocalDate reportDate = convertStringToLocalDate(stringReportDate);
       this.reportDate = reportDate;
        System.out.println("inilho"+this.reportDate);
    }

    public LocalDate convertStringToLocalDate(String stringDate){
        LocalDate convertedDate = LocalDate.parse(stringDate, DateTimeFormat.forPattern("yyyy-mm-dd"));
        return convertedDate;
    }
}
