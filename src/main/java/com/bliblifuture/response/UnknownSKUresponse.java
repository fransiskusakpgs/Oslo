package com.bliblifuture.response;

/**
 * Created by Fransiskus A K on 06/04/2017.
 */
public class UnknownSKUresponse {
    private long id;
    private String storageCode;
    private int physicalQty;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
