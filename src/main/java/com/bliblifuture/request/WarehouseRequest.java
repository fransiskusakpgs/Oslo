package com.bliblifuture.request;

import java.io.Serializable;
import java.util.List;

public class WarehouseRequest implements Serializable{
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
