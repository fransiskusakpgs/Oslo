package com.bliblifuture.request;


import java.io.Serializable;

public class UpdateQuantityRequest implements Serializable {
    private String skuId;
    public String physicalQty;
    private String information;


    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getPhysicalQty() {
        return physicalQty;
    }

    public void setPhysicalQty(String physicalQty) {
        this.physicalQty = physicalQty;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
