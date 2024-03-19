package com.wimika.ionic;

import com.google.gson.annotations.SerializedName;

public class CredentialScanResult {
    @SerializedName("Message")
    private String message;

    @SerializedName("Status")
    private RiskStatus status;

    // Constructor
    public CredentialScanResult(String message, RiskStatus status) {
        this.message = message;
        this.status = status;
    }

    // Getters and setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public RiskStatus getStatus() {
        return status;
    }

    public void setStatus(RiskStatus status) {
        this.status = status;
    }
}