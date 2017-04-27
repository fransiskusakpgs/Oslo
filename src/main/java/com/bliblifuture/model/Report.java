package com.bliblifuture.model;

import org.joda.time.LocalDate;
import javax.persistence.*;
import java.util.List;

@Entity
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private LocalDate date;
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



    public String getDate() {
       String stringDate = date.toString();
        return stringDate;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

//    Fungsi ini ditambahkan untuk tujuan testing.
//    Fungsi ini mengecek kesamaan isi antara 2 object.

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        Report report = (Report) o;
        if(!date.equals(report.date)) return false;
        if(countedQty != report.countedQty) return false;
        if(countedSKU != report.countedSKU) return false;
        if(deficitQty != report.deficitQty) return false;
        if(deficitSKU != report.deficitSKU) return false;
        if(surplusQty != report.surplusQty) return false;
        if(surplusSKU != report.surplusSKU) return false;
        if(totalUnknownQty != report.totalUnknownQty) return false;
        if(totalUnknownSKU != report.totalUnknownSKU) return false;
        return stockOpnames != null ? stockOpnames.containsAll(report.stockOpnames):
                report.stockOpnames == null;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Report{");
        sb.append("id=").append(id);
        sb.append(", date=").append(date);
        sb.append(", countedSKU=").append(countedSKU);
        sb.append(", countedQty=").append(countedQty);
        sb.append(", deficitSKU=").append(deficitSKU);
        sb.append(", deficitQty=").append(deficitQty);
        sb.append(", surplusSKU=").append(surplusSKU);
        sb.append(", surplusQty=").append(surplusQty);
        sb.append(", totalUnknownSKU=").append(totalUnknownSKU);
        sb.append(", totalUnknownQty=").append(totalUnknownQty);
        sb.append(", stockOpnames=").append(stockOpnames);
        sb.append('}');
        return sb.toString();
    }
}
