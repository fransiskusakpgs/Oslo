package com.bliblifuture.request;

import java.io.Serializable;


public class SKURequest implements Serializable{

    private String SKUid;
    private String itemName;
    private String stockType;
    private String storageCode;
    private String systemQty;
    private String information;
//    private StockOpname stockOpname;

    public String getSKUid() {
        return SKUid;
    }

    public void setSKUid(String SKUid) {
        this.SKUid = SKUid;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getStockType() {
        return stockType;
    }

    public void setStockType(String stockType) {
        this.stockType = stockType;
    }

    public String getStorageCode() {
        return storageCode;
    }

    public void setStorageCode(String storageCode) {
        this.storageCode = storageCode;
    }

    public String getSystemQty() {
        return systemQty;
    }

    public void setSystemQty(String systemQty) {
        this.systemQty = systemQty;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
