package com.bliblifuture.response;

public class BaseResponse {
    private boolean success;
    private String errorMessage;

    public BaseResponse(Boolean success, String errorMessage){
        this.success = true;
        this.errorMessage = errorMessage;
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
}
