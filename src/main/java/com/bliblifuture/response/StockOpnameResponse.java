package com.bliblifuture.response;


import java.util.Date;

public class StockOpnameResponse {
    private String stockOpnameId;
    private String Status;
    private Date waktuPembuatan;
    private String assignedTo;
    private String totalQty;
    private String totalSKU;


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

    public String getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(String totalQty) {
        this.totalQty = totalQty;
    }

    public String getTotalSKU() {
        return totalSKU;
    }

    public void setTotalSKU(String totalSKU) {
        this.totalSKU = totalSKU;
    }
}
