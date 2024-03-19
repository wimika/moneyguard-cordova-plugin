package com.wimika.ionic;

import com.google.gson.annotations.SerializedName;

public class Score {
    @SerializedName("minimum")
    private int minimum;

    @SerializedName("maximum")
    private int maximum;

    @SerializedName("value")
    private int value;

    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
