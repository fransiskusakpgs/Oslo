package com.bliblifuture.model;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Entity
@Table(name="stockOpname")
public class StockOpname {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String Counter;
    private String Status;
    private Date waktuPembuatan;
    private String totalQty;
    private String SKU;

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

    public Date getWaktuPembuatan() {
        return this.waktuPembuatan;
    }

    public void setWaktuPembuatan(Date waktuPembuatan) {
        this.waktuPembuatan = waktuPembuatan;
    }

    public void formatWaktuPembuatan(String waktuPembuatan){
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd hh:mm:ss");
            Date la = sdf.parse(waktuPembuatan);
            this.waktuPembuatan = la;
        } catch (ParseException e) {
            e.printStackTrace();
        }
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
