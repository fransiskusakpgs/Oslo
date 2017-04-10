package com.bliblifuture.request;

import com.bliblifuture.model.SKU;
import com.bliblifuture.model.StockOpname;
import com.bliblifuture.model.UnknownSKU;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StockOpnameRequest implements Serializable{

    private String Status;
    private String waktuPembuatan;
    private int totalQty;
    private int totalSKU;
    private List<SKURequest> SKUs = new ArrayList<>();
    private List<String> UnknownSKUs = new ArrayList<>();

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

    public List<SKURequest> getSKUs() {
        return SKUs;
    }

    public void setSKUs(List<SKURequest> SKUs) {
        this.SKUs = SKUs;
    }

    public List<String> getUnknownSKUs() {
        return UnknownSKUs;
    }

    public void setUnknownSKUs(List<String> unknownSKUs) {
        UnknownSKUs = unknownSKUs;
    }
}
