package com.bliblifuture.model;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String date;
    private int countedSKU;
    private int countedQty;
    private int deficitSKU;
    private int deficitQty;
    private int surplusSKU;
    private int surplusQty;
    private int totalUnknownSKU;
    private int totalUnknownQty;

    @OneToMany
    private List<StockOpname> stockOpnames;

    public void countSKU(){
        int countedSKU = 0;
        int uncountedSKU = 0;
        int totalUnknwonQty = 0;
        int totalUnknwonSKU = 0;
        for (StockOpname stockOpname: stockOpnames) {
            List<SKU> skus = stockOpname.getSKUs();
            List<UnknownSKU> unknownSKUs = stockOpname.getUnknownSKUs();
            for (SKU sku: skus) {
                String status = sku.getInformation();
                if (status.equals("COUNTED")){
                    countedSKU++;
                }
                else{
                    uncountedSKU++;
                }
            }

            for (UnknownSKU unknownSKU: unknownSKUs) {
                totalUnknwonQty += unknownSKU.getPhysicalQty();
                totalUnknwonSKU++;
            }
        }
        this.countedSKU = countedSKU;
        this.totalUnknownQty = totalUnknwonQty;
        this.totalUnknownSKU = totalUnknwonSKU;
    }

    public void countQty(){
        int countedQty = 0;
        int deficitQty = 0;
        int surplusQty = 0;
        int deficitSKU = 0;
        int surplusSKU = 0;
        for (StockOpname stockOpname: stockOpnames) {
            List<SKU> skus = stockOpname.getSKUs();
            for (SKU sku: skus) {
                String status = sku.getInformation();
                if (status.equals("COUNTED")){

                    countedQty += sku.getPhysicalQty();

                    int sistemQty = sku.getSystemQty();
                    int fisikQty =sku.getPhysicalQty();
                    int selisih = sistemQty-fisikQty;

                    if (selisih>0){
                        deficitQty += Math.abs(selisih);
                        deficitSKU++;
                    } else if (selisih < 0) {
                        surplusQty += selisih;
                        surplusSKU++;
                    }
                }
            }
        }
        this.deficitSKU = deficitSKU;
        this.surplusSKU = surplusSKU;
        this.countedQty = countedQty;
        this.deficitQty = deficitQty;
        this.surplusQty = surplusQty;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCountedSKU() {
        return countedSKU;
    }

    public void setCountedSKU(int countedSKU) {
        this.countedSKU = countedSKU;
    }

    public int getCountedQty() {
        return countedQty;
    }

    public void setCountedQty(int countedQty) {
        this.countedQty = countedQty;
    }

    public int getDeficitSKU() {
        return deficitSKU;
    }

    public void setDeficitSKU(int deficitSKU) {
        this.deficitSKU = deficitSKU;
    }

    public int getDeficitQty() {
        return deficitQty;
    }

    public void setDeficitQty(int deficitQty) {
        this.deficitQty = deficitQty;
    }

    public int getSurplusSKU() {
        return surplusSKU;
    }

    public void setSurplusSKU(int surplusSKU) {
        this.surplusSKU = surplusSKU;
    }

    public int getSurplusQty() {
        return surplusQty;
    }

    public void setSurplusQty(int surplusQty) {
        this.surplusQty = surplusQty;
    }

    public int getTotalUnknownSKU() {
        return totalUnknownSKU;
    }

    public void setTotalUnknownSKU(int totalUnknownSKU) {
        this.totalUnknownSKU = totalUnknownSKU;
    }

    public int getTotalUnknownQty() {
        return totalUnknownQty;
    }

    public void setTotalUnknownQty(int totalUnknownQty) {
        this.totalUnknownQty = totalUnknownQty;
    }

    public List<StockOpname> getStockOpnames() {
        return stockOpnames;
    }

    public void setStockOpnames(List<StockOpname> stockOpnames) {
        this.stockOpnames = stockOpnames;
    }
}
