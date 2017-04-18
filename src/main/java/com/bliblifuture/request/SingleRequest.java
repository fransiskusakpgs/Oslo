package com.bliblifuture.request;

import java.io.Serializable;

public class SingleRequest implements Serializable{ //Serializable agar bisa dirubah ke String
    private String data; //bisa diisi nilai apapun dan dibungkus si SingleRq, misalnya stockopname id

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
