package com.bliblifuture.response;

public class SingleUserResponse {

        private boolean success;
        private String errorMessage;
        private UserResponse data;

        public SingleUserResponse(Boolean success, String errorMessage, UserResponse data){
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

        public UserResponse getData() {
            return data;
        }

        public void setData(UserResponse data) {
            this.data = data;
        }
}
