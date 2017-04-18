package com.bliblifuture.request;

import com.bliblifuture.model.StockOpname;

import java.io.Serializable;

public class UnknownSKURequest implements Serializable{

    private String unknownSKUid;
    private String storageCode;
    private int physicalQty;
    private String stockOpnameId;

    public String getUnknownSKUid() {
        return unknownSKUid;
    }

    public void setUnknownSKUid(String unknownSKUid) {
        this.unknownSKUid = unknownSKUid;
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

    public String getStockOpnameId() {
        return stockOpnameId;
    }

    public void setStockOpnameId(String stockOpnameId) {
        this.stockOpnameId = stockOpnameId;
    }
}
