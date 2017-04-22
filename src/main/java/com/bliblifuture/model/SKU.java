package com.bliblifuture.model;

import javax.persistence.*;

@Entity
@Table(name="SKU")
public class SKU {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String SKUid;
    private String itemName;
    private String stockType;
    private String storageCode;
    private int systemQty;
    private int physicalQty;
    private int deviationQty;
    private String information;
    @ManyToOne
    @JoinColumn(name = "stockopname_id")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SKU sku = (SKU) o;
        if(!SKUid.equals(sku.SKUid))return false;
        if(!itemName.equals(sku.itemName))return false;
        if(!stockType.equals(sku.stockType))return false;
        if(!storageCode.equals(sku.storageCode))return false;
        if(systemQty != sku.systemQty)return false;
        if(physicalQty != sku.physicalQty)return false;
        if(deviationQty != sku.deviationQty)return false;
        if(!information.equals(sku.information)) return false;
        return stockOpname!= null ? stockOpname.equals(sku.stockOpname):
                sku.stockOpname == null;
    }
}






