    package com.bliblifuture.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="stockOpname")
public class StockOpname {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String stockOpnameId;
    private String Counter;
    private String Status;
    private String waktuPembuatan;
    private int totalQty;
    private int totalSKU;
    @OneToMany
    private List<SKU> SKUs = new ArrayList<>();
    @OneToMany
    private List<UnknownSKU> UnknownSKUs = new ArrayList<>();

    public String getStockOpnameId() {
        return stockOpnameId;
    }

    public void setStockOpnameId(String stockOpnameId) {
        this.stockOpnameId = stockOpnameId;
    }

    public String getCounter() {
        return Counter;
    }

    public void setCounter(String counter) {
        Counter = counter;
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
        return UnknownSKUs;
    }

    public void setUnknownSKUs(List<UnknownSKU> unknownSKUs) {
        UnknownSKUs = unknownSKUs;
    }

    public void addUnknownSKU(UnknownSKU unknownSKU){
        this.UnknownSKUs.add(unknownSKU);
    }


    public int getTotalQty() {
        return totalQty;
    }


    public void setTotalQty(int totalQty) {
        this.totalQty = totalQty;
    }

    public void countTotalQty(){
        int total = 0;
        for (SKU sku: SKUs) {
            total = total + sku.getSystemQty();
        }
        this.totalQty = total;
    }

    public int getTotalSKU() {
        return totalSKU;
    }

    public void setTotalSKU(int totalSKU ) {
        this.totalSKU = totalSKU;
    }
    public void countTotalSKU() {
        totalSKU = SKUs.size();

    }








}
