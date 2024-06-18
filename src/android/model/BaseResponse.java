package com.wimika.ionic;

import com.google.gson.annotations.SerializedName;

public class BaseResponse {

    @SerializedName("success")
    private boolean success;

    @SerializedName("message")
    private String message;
    
    @SerializedName("status")
    private int status;

    // Getters and Setters
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
