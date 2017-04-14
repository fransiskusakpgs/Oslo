    package com.bliblifuture.model;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="stockOpname")
public class StockOpname {
    @Id
    private String stockOpnameId;
    private Date waktuPembuatan;
    private String Status;
    private int totalQty;
    private int totalSKU;

    @OneToMany
    private List<SKU> SKUs = new ArrayList<>();
    @OneToMany
    private List<UnknownSKU> unknownSKUs = new ArrayList<>();
    @ManyToOne
    private Counter assignedTo;
  
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

    public void formatWaktuPembuatan(String waktuPembuatan){
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd hh:mm:ss");
            Date la = sdf.parse(waktuPembuatan);
            this.waktuPembuatan = la;
        } catch (ParseException e) {
            e.printStackTrace();
        }
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

    public Date getWaktuPembuatan() {
        return this.waktuPembuatan;
    }

    public void setWaktuPembuatan(Date waktuPembuatan) {
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
        return unknownSKUs;
    }

    public void setUnknownSKUs(List<UnknownSKU> unknownSKUs) {
        unknownSKUs = unknownSKUs;
    }

    public void addUnknownSKU(UnknownSKU unknownSKU){
        this.unknownSKUs.add(unknownSKU);
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
}
