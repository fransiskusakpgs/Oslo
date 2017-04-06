package com.bliblifuture.response;

import java.io.Serializable;
import java.util.List;
//Http Template
public class ListResponse<T> implements Serializable {

    private List<T> data;
    private boolean success;
    private String errorMessage;

    public ListResponse(Boolean success, String errorMessage,List<T> data){
        this.data = data;
        this.success = true;
        this.errorMessage = errorMessage;
    }

    public List<T> getData() {
        return data;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
