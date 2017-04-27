package com.bliblifuture.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StockOpnameRequest implements Serializable{
    private String stockOpnameId;
    private String Status;
    private String waktuPembuatan;
    private List<SKURequest> SKUs = new ArrayList<>();

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

    public String getWaktuPembuatan() {
        return waktuPembuatan;
    }

    public void setWaktuPembuatan(String waktuPembuatan) {
        this.waktuPembuatan = waktuPembuatan;
    }

    public List<SKURequest> getSKUs() {
        return SKUs;
    }

    public void setSKUs(List<SKURequest> SKUs) {
        this.SKUs = SKUs;
    }
}
