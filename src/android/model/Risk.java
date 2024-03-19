package com.wimika.ionic;

import com.google.gson.annotations.SerializedName;

public class Risk {
    @SerializedName("name")
    private String name;

    @SerializedName("categoryName")
    private String categoryName;

    @SerializedName("score")
    private Score score;

    @SerializedName("status")
    private int status;

    @SerializedName("additionalDetails")
    private String additionalDetails;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAdditionalDetails() {
        return additionalDetails;
    }

    public void setAdditionalDetails(String additionalDetails) {
        this.additionalDetails = additionalDetails;
    }
}


