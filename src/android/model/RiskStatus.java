package com.wimika.ionic;

import com.google.gson.annotations.SerializedName;

public enum RiskStatus {
    @SerializedName("RISK_STATUS_UNKNOWN")
    RISK_STATUS_UNKNOWN,

    @SerializedName("RISK_STATUS_SAFE")
    RISK_STATUS_SAFE,

    @SerializedName("RISK_STATUS_WARN")
    RISK_STATUS_WARN,

    @SerializedName("RISK_STATUS_UNSAFE")
    RISK_STATUS_UNSAFE
}
