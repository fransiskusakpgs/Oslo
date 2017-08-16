package com.bliblifuture.response;

public class SingleStockOpnameResponse {

    private boolean success;
    private String errorMessage;
    private StockOpnameResponse data;

    public SingleStockOpnameResponse(Boolean success, String errorMessage, StockOpnameResponse data) {
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

    public void setData(StockOpnameResponse data) {
        this.data = data;
    }

    public StockOpnameResponse getData() {
        return data;
    }
}

