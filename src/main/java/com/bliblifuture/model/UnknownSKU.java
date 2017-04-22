package com.bliblifuture.model;

import javax.persistence.*;


@Entity
@Table(name="UnknownSKU")
public class UnknownSKU {

    @Id
    private String unknownSKUId;
    private String storageCode;
    private int physicalQty;
//    @ManyToOne
//    @JoinColumn(name = "stockopname_Id")
//    private StockOpname stockOpname;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UnknownSKU unknownSKU = (UnknownSKU) o;
        if(!storageCode.equals(unknownSKU.storageCode)) return false;
        if(!unknownSKUId.equals(unknownSKU.unknownSKUId)) return false;
        return physicalQty != unknownSKU.physicalQty;
    }
}
