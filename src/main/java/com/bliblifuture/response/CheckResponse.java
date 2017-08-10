package com.bliblifuture.response;

public class CheckResponse {
    private boolean success;
    private String errorMessage;
    private boolean sto;
    private boolean storageCode;

    public CheckResponse(boolean success, String errorMessage,boolean sto,boolean storageCode){
        this.success = success;
        this.errorMessage = errorMessage;
        this.sto = sto;
        this.storageCode = storageCode;
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

    public boolean isSto() {
        return sto;
    }

    public void setSto(boolean sto) {
        this.sto = sto;
    }

    public boolean isStorageCode() {
        return storageCode;
    }

    public void setStorageCode(boolean storageCode) {
        this.storageCode = storageCode;
    }
}
