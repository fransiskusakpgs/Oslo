package com.bliblifuture.request;

import com.bliblifuture.model.StockOpname;

import java.io.Serializable;

public class UnknownSKURequest implements Serializable{

    private String stockOpnameId;
    private String unknownSKUId;
    private String storageCode;
    private int physicalQty;

    public String getStockOpnameId() {
        return stockOpnameId;
    }

    public void setStockOpnameId(String stockOpnameId) {
        this.stockOpnameId = stockOpnameId;
    }

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

//    public void setStockOpname(StockOpname stockOpname) {
//        this.stockOpname = stockOpname;
//    }
//
//    public StockOpname getStockOpname() {
//        return stockOpname;
//    }

}
