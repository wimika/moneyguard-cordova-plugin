package com.wimika.ionic;

import com.google.gson.annotations.SerializedName;

public class MoneyGuardSessionResponse {

    @SerializedName("token")
    private String token;

    @SerializedName("partnerBank")
    private String partnerBank;

    @SerializedName("serviceUrl")
    private String serviceUrl;

    @SerializedName("expiresIn")
    private double expiresIn;

    @SerializedName("userDetails")
    private UserDetails userDetails;

    // Getters and Setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPartnerBank() {
        return partnerBank;
    }

    public void setPartnerBank(String partnerBank) {
        this.partnerBank = partnerBank;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public double getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(double expiresIn) {
        this.expiresIn = expiresIn;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }
}
