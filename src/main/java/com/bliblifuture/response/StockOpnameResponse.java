package com.bliblifuture.response;

/**
 * Created by Fransiskus A K on 11/03/2017.
 */
public class StockOpnameResponse {

    private long id;
    private String Counter;
    private String Status;
    private String waktuPembuatan;
    private String totalQty;
    private String SKU;


    //dibikin getter setter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCounter() {
        return Counter;
    }

    public void setCounter(String counter) {
        Counter = counter;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getWaktuPembuatan() {
        return waktuPembuatan;
    }

    public void setWaktuPembuatan(String waktuPembuatan) {
        this.waktuPembuatan = waktuPembuatan;
    }

    public String getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(String totalQty) {
        this.totalQty = totalQty;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }
}
