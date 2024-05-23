package com.wimika.ionic;

import com.google.gson.annotations.SerializedName;


public class GenericResult<T> {

    private T data;

    @SerializedName("isError")
    private boolean IsError;

    @SerializedName("errorMessage")
    private String ErrorMessage;


    // Constructor
    public GenericResult(T data, boolean IsError, String ErrorMessage) {
        this.data = data;
        this.IsError = IsError;
        this.ErrorMessage = ErrorMessage;
    }

    // Getters and Setters
    public boolean isError() {
        return IsError;
    }

    public void setError(boolean error) {
        this.IsError = error;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.ErrorMessage = errorMessage;
    }

    public T getData() {
      return data;
    }

    public void setData(T data) {
      this.data = data;
    }

}
