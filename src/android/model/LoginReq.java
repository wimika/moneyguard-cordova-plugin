package com.wimika.ionic;

import com.google.gson.annotations.SerializedName;

public class LoginReq {
    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String password;

    public LoginReq(String username, String password) {
        this.email = username;
        this.password = password;
    }

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
