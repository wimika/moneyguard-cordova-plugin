package com.wimika.ionic.Moneyguard;


import com.google.gson.annotations.SerializedName;

public class DebitCheckReq {
    @SerializedName("sourceAccountNumber")
    private String sourceAccountNumber;

    @SerializedName("amount")
    private int amount;

    @SerializedName("memo")
    private String memo;

    @SerializedName("destinationBank")
    private String destinationBank;

    @SerializedName("destinationAccountNumber")
    private String destinationAccountNumber;

    // Constructor
    public DebitCheckReq(String sourceAccountNumber, int amount, String memo, String destinationBank, String destinationAccountNumber) {
        this.sourceAccountNumber = sourceAccountNumber;
        this.amount = amount;
        this.memo = memo;
        this.destinationBank = destinationBank;
        this.destinationAccountNumber = destinationAccountNumber;
    }

    // Getters and Setters
    public String getSourceAccountNumber() {
        return sourceAccountNumber;
    }

    public void setSourceAccountNumber(String sourceAccountNumber) {
        this.sourceAccountNumber = sourceAccountNumber;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getDestinationBank() {
        return destinationBank;
    }

    public void setDestinationBank(String destinationBank) {
        this.destinationBank = destinationBank;
    }

    public String getDestinationAccountNumber() {
        return destinationAccountNumber;
    }

    public void setDestinationAccountNumber(String destinationAccountNumber) {
        this.destinationAccountNumber = destinationAccountNumber;
    }
}
