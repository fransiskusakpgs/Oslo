package com.bliblifuture.model;

import javax.persistence.*;

/**
 * Created by Fransiskus A K on 06/04/2017.
 */
@Entity
@Table(name="UnknownSKU")
public class UnknownSKU {
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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String storageCode;
    private int physicalQty;


}
