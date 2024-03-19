package com.wimika.ionic;

import com.google.gson.annotations.SerializedName;

public class TypingProfileResult {
    @SerializedName("success")
    private boolean success;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private int status;

    @SerializedName("isEnrolledOnThisDevice")
    private boolean isEnrolledOnThisDevice;

    @SerializedName("matched")
    private boolean matched;

    @SerializedName("highConfidence")
    private boolean highConfidence;

    @SerializedName("hasOtherEnrollments")
    private boolean hasOtherEnrollments;

    // Getters and Setters
    // You can generate these using your IDE's built-in functionality or manually like this:

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

    public boolean isEnrolledOnThisDevice() {
        return isEnrolledOnThisDevice;
    }

    public void setEnrolledOnThisDevice(boolean enrolledOnThisDevice) {
        isEnrolledOnThisDevice = enrolledOnThisDevice;
    }

    public boolean isMatched() {
        return matched;
    }

    public void setMatched(boolean matched) {
        this.matched = matched;
    }

    public boolean isHighConfidence() {
        return highConfidence;
    }

    public void setHighConfidence(boolean highConfidence) {
        this.highConfidence = highConfidence;
    }

    public boolean hasOtherEnrollments() {
        return hasOtherEnrollments;
    }

    public void setHasOtherEnrollments(boolean hasOtherEnrollments) {
        this.hasOtherEnrollments = hasOtherEnrollments;
    }
}
