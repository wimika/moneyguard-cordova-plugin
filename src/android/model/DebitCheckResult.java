package com.wimika.ionic.Moneyguard;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class DebitCheckResult {
    @SerializedName("success")
    private boolean success;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private int status;

    @SerializedName("risks")
    private List<Risk> risks;

    // Constructor
    public DebitCheckResult(boolean success, String message, int status, List<Risk> risks) {
        this.success = success;
        this.message = message;
        this.status = status;
        this.risks = risks;
    }

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

    public List<Risk> getRisks() {
        return risks;
    }

    public void setRisks(List<Risk> risks) {
        this.risks = risks;
    }
}
