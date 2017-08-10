package com.bliblifuture.response;


import com.bliblifuture.model.SKU;

public class SKUSingleResponse {
    private boolean success;
    private String errorMessage;
    private SKU skuData;

    public SKUSingleResponse(Boolean success, String errorMessage, SKU data){
        this.success = true;
        this.errorMessage = errorMessage;
        this.skuData = data;
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

    public SKU getSkuData() {
        return skuData;
    }

    public void setSkuData(SKU skuData) {
        this.skuData = skuData;
    }
}