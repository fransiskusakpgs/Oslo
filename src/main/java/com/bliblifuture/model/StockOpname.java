package com.bliblifuture.model;

import javax.persistence.*;

@Entity
@Table(name="stockOpname")
public class StockOpname {
    @Id
    private String stockOpnameId;
    private String Status;
    private String waktuPembuatan;
    private int totalQty;
    private int totalSKU;

    public String getStockOpnameId() {
        return stockOpnameId;
    }

    public void setStockOpnameId(String stockOpnameId) {
        this.stockOpnameId = stockOpnameId;
    }

    public int getTotalQty() {
        return totalQty;
    }

    public int getTotalSKU() {
        return totalSKU;
    }

    public void setTotalSKU(int totalSKU) {
        this.totalSKU = totalSKU;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getWaktuPembuatan() {
        return waktuPembuatan;
    }

    public void setWaktuPembuatan(String waktuPembuatan) {
        this.waktuPembuatan = waktuPembuatan;
    }

    public void setTotalQty(int totalQty) {
        this.totalQty = totalQty;
    }

}
