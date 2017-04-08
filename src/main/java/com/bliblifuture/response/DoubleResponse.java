package com.bliblifuture.response;

import java.io.Serializable;
import java.util.List;

public class DoubleResponse<T> implements Serializable {
    private List<T> data;
    private List<T> data2;
    private String errorMessage;
    private boolean success;

    public List<T> getData() {
        return data;
    }

    public List<T> getData2() {
        return data2;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Boolean isSuccess() {
        return  success;
    }

    public DoubleResponse(Boolean success, String errorMessage, List<T> data, List<T> data2){
        this.data = data;
        this.data2 = data2;
        this.success = true;
        this.errorMessage = errorMessage;
    }
}
