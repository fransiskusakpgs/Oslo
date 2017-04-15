package com.bliblifuture.request;

import java.io.Serializable;

public class StringRequest implements Serializable {

    private String data;

    public String getData() {
        return data;
    }

    public void setDate(String data) {
        this.data = data;
    }
}
