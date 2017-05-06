package com.bliblifuture.model;

import com.bliblifuture.OsloConstanta;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name="stockOpname")
public class StockOpname {
    @Id
    private String stockOpnameId;
    private LocalDate waktuPembuatan;
    private String status;
    private LocalDateTime startCountingTime;
    private LocalDateTime finishCountingTime;
    private LocalDate reportDate;
    private int totalQty;
    private int totalSKU;

    @ManyToOne
    private Counter assignedTo;
    @ManyToOne
    private Report report;

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
        SimpleDateFormat sdf = new SimpleDateFormat(OsloConstanta.DATE_FORMAT);
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
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
    }

    public LocalDate convertStringToLocalDate(String stringDate){
        LocalDate convertedDate = LocalDate.parse(stringDate, DateTimeFormat.forPattern(OsloConstanta.DATE_FORMAT));
        return convertedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockOpname stockOpname = (StockOpname) o;
        if(!stockOpnameId.equals(stockOpname.stockOpnameId)) return false;
        if(!waktuPembuatan.equals(stockOpname.waktuPembuatan))return false;
        if(!status.equals(stockOpname.waktuPembuatan))return false;
        if(!startCountingTime.equals(stockOpname.startCountingTime))return false;
        if(!finishCountingTime.equals(stockOpname.finishCountingTime))return false;
        if(totalQty != stockOpname.totalQty )return false;
        if(totalSKU != stockOpname.totalSKU )return false;
        if(!reportDate.equals(stockOpname.reportDate)) return false;
        return !reportDate.equals(stockOpname.reportDate);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StockOpname{");
        sb.append("stockOpnameId='").append(stockOpnameId).append('\'');
        sb.append(", waktuPembuatan=").append(waktuPembuatan);
        sb.append(", status='").append(status).append('\'');
        sb.append(", startCountingTime=").append(startCountingTime);
        sb.append(", finishCountingTime=").append(finishCountingTime);
        sb.append(", reportDate=").append(reportDate);
        sb.append(", totalQty=").append(totalQty);
        sb.append(", totalSKU=").append(totalSKU);
        sb.append(", assignedTo=").append(assignedTo);
        sb.append(", report=").append(report);
        sb.append('}');
        return sb.toString();
    }
}
