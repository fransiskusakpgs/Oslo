package com.bliblifuture.response;


import com.bliblifuture.model.Report;

public class SingleSKUResponse {
    private boolean success;
    private String errorMessage;
    private SKUresponse data;

    public SingleSKUResponse(Boolean success, String errorMessage, SKUresponse data){
        this.success = true;
        this.errorMessage = errorMessage;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setData(SKUresponse data) {
        this.data = data;
    }

    public SKUresponse getData() {
        return data;
    }
}