package com.wimika.ionic;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import com.wimika.moneyguard.risk.SpecificRisk;

public class RiskResult {
    @SerializedName("success")
    private boolean success;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private RiskStatus status;

    @SerializedName("risks")
    private List<SpecificRisk> risks;

    // Constructor
    public RiskResult(boolean success, String message, RiskStatus status, List<SpecificRisk> risks) {
        this.success = success;
        this.message = message;
        this.status = status;
        this.risks = risks;
    }

    // Getters
    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public RiskStatus getStatus() {
        return status;
    }

    public List<SpecificRisk> getRisks() {
        return risks;
    }

    // Setters
    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(RiskStatus status) {
        this.status = status;
    }

    public void setRisks(List<SpecificRisk> risks) {
        this.risks = risks;
    }
}

