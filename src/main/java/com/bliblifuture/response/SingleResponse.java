package com.bliblifuture.response;


import com.bliblifuture.model.Report;

public class SingleResponse {
    private boolean success;
    private String errorMessage;
    private Report data;

    public SingleResponse(Boolean success, String errorMessage, Report data){
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

    public Report getData() {
        return data;
    }

    public void setData(Report data) {
        this.data = data;
    }
}