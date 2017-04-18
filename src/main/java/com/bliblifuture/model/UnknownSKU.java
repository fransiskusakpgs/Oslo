package com.bliblifuture.model;

import javax.persistence.*;


@Entity
@Table(name="UnknownSKU")
public class UnknownSKU {

    @Id
    private String unknownSKUId;
    private String storageCode;
    private int physicalQty;

    @ManyToOne
    private StockOpname stockOpname;

    public String getUnknownSKUId() {
        return unknownSKUId;
    }

    public void setUnknownSKUId(String unknownSKUId) {
        this.unknownSKUId = unknownSKUId;
    }

    public String getStorageCode() {
        return storageCode;
    }

    public void setStorageCode(String storageCode) {
        this.storageCode = storageCode;
    }

    public int getPhysicalQty() {
        return physicalQty;
    }

    public void setPhysicalQty(int physicalQty) {
        this.physicalQty = physicalQty;
    }

    public StockOpname getStockOpname() {
        return stockOpname;
    }

    public void setStockOpname(StockOpname stockOpname) {
        this.stockOpname = stockOpname;
    }
}
