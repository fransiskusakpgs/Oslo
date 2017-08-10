package com.bliblifuture.response;


import org.joda.time.DateTime;

import java.util.Date;

public class StockOpnameResponse {
    private String stockOpnameId;
    private String Status;
    private Date waktuPembuatan;
    private String assignedTo;
    private int totalQty;
    private int totalSKU;
    private Date startCountingTime;
    private Date finishCountingTime;


    public String getStockOpnameId() {
        return stockOpnameId;
    }

    public void setStockOpnameId(String stockOpnameId) {
        this.stockOpnameId = stockOpnameId;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Date getWaktuPembuatan() {
        return waktuPembuatan;
    }

    public void setWaktuPembuatan(Date waktuPembuatan) {
        this.waktuPembuatan = waktuPembuatan;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
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

    public void setTotalSKU(int totalSKU) {
        this.totalSKU = totalSKU;
    }

    public Date getStartCountingTime() {
        return startCountingTime;
    }

    public void setStartCountingTime(Date startCountingTime) {
        this.startCountingTime = startCountingTime;
    }

    public Date getFinishCountingTime() {
        return finishCountingTime;
    }

    public void setFinishCountingTime(Date finishCountingTime) {
        this.finishCountingTime = finishCountingTime;
    }
}
