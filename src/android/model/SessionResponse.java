package com.wimika.ionic;

import com.google.gson.annotations.SerializedName;

public class SessionResponse {
    @SerializedName("sessionId")
    private String sessionId;

    // Constructor
    public SessionResponse(String sessionId) {
        this.sessionId = sessionId;
    }

    // Getter and setter for sessionId
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
