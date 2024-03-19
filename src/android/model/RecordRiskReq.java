package com.wimika.ionic;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class RecordRiskReq {
    @SerializedName("specificRisks")
    private List<Risk> specificRisks;

    public List<Risk> getSpecificRisks() {
        return specificRisks;
    }

    public void setSpecificRisks(List<Risk> specificRisks) {
        this.specificRisks = specificRisks;
    }
}
