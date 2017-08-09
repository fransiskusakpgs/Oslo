package com.bliblifuture.response;

import com.bliblifuture.model.User;

public class SingleUserResponse {

        private boolean success;
        private String errorMessage;
        private User data;

        public SingleUserResponse(Boolean success, String errorMessage, User data){
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

        public User getData() {
            return data;
        }

        public void setData(User data) {
            this.data = data;
        }
}
