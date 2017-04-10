package com.bliblifuture.request;

import com.bliblifuture.model.StockOpname;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SKURequest implements Serializable{

    private String SKUid;
    private String itemName;
    private String stockType;
    private String storageCode;
    private int systemQty;
    private int physicalQty;
    private int deviationQty;
    private String information;
    private StockOpname stockOpname;

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

    public int getSystemQty() {
        return systemQty;
    }

    public void setSystemQty(int systemQty) {
        this.systemQty = systemQty;
    }

    public int getPhysicalQty() {
        return physicalQty;
    }

    public void setPhysicalQty(int physicalQty) {
        this.physicalQty = physicalQty;
    }

    public int getDeviationQty() {
        return deviationQty;
    }

    public void setDeviationQty(int deviationQty) {
        this.deviationQty = deviationQty;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public StockOpname getStockOpname() {
        return stockOpname;
    }

    public void setStockOpname(StockOpname stockOpname) {
        this.stockOpname = stockOpname;
    }
}
