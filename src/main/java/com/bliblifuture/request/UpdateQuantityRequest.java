package com.bliblifuture.request;


import java.io.Serializable;

public class UpdateQuantityRequest implements Serializable {
    private String SKUid;
    public int physicalQty;

    public String getSKUid() {
        return SKUid;
    }

    public void setSKUid(String SKUid) {
        this.SKUid = SKUid;
    }

    public int getPhysicalQty() {
        return physicalQty;
    }

    public void setPhysicalQty(int physicalQty) {
        this.physicalQty = physicalQty;
    }
}
