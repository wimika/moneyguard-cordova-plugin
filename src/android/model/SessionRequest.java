package com.wimika.ionic;

import com.google.gson.annotations.SerializedName;

public class SessionRequest {

    @SerializedName("partnerId")
    private int partnerId;

    @SerializedName("partnerSessionToken")
    private String partnerSessionToken;

    @SerializedName("installationId")
    private String installationId;

  public SessionRequest(int partnerId, String partnerSessionToken, String installationId) {
    this.partnerId = partnerId;
    this.partnerSessionToken = partnerSessionToken;
    this.installationId = installationId;
  }

  public int getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(int partnerId) {
        this.partnerId = partnerId;
    }

    public String getPartnerSessionToken() {
        return partnerSessionToken;
    }

    public void setPartnerSessionToken(String partnerSessionToken) {
        this.partnerSessionToken = partnerSessionToken;
    }

    public String getInstallationId() {
        return installationId;
    }

    public void setInstallationId(String installationId) {
        this.installationId = installationId;
    }
}
