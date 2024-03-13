package com.wimika.ionic.Moneyguard;

import com.google.gson.annotations.SerializedName;

public class CredentialCheckReq {
    @SerializedName("username")
    private String username;

    @SerializedName("passwordStartingCharactersHash")
    private String passwordStartingCharactersHash;

    @SerializedName("passwordFragmentLength")
    private int passwordFragmentLength;

    @SerializedName("hashAlgorithm")
    private String hashAlgorithm;

    @SerializedName("domain")
    private String domain;

    // Constructor
    public CredentialCheckReq(String username, String passwordStartingCharactersHash, int passwordFragmentLength, String hashAlgorithm, String domain) {
        this.username = username;
        this.passwordStartingCharactersHash = passwordStartingCharactersHash;
        this.passwordFragmentLength = passwordFragmentLength;
        this.hashAlgorithm = hashAlgorithm;
        this.domain = domain;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordStartingCharactersHash() {
        return passwordStartingCharactersHash;
    }

    public void setPasswordStartingCharactersHash(String passwordStartingCharactersHash) {
        this.passwordStartingCharactersHash = passwordStartingCharactersHash;
    }

    public int getPasswordFragmentLength() {
        return passwordFragmentLength;
    }

    public void setPasswordFragmentLength(int passwordFragmentLength) {
        this.passwordFragmentLength = passwordFragmentLength;
    }

    public String getHashAlgorithm() {
        return hashAlgorithm;
    }

    public void setHashAlgorithm(String hashAlgorithm) {
        this.hashAlgorithm = hashAlgorithm;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
