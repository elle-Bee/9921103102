package com.example.httpMicroservice;

public class AuthorizationRequest {
    private String companyName;
    private String clientID;
    private String clientSecret;
    private String ownerName;
    private String ownerEmail;
    private String rollNo;

    public AuthorizationRequest(String companyName, String clientID, String clientSecret, String ownerName, String ownerEmail, String rollNo) {
        this.companyName = companyName;
        this.clientID = clientID;
        this.clientSecret = clientSecret;
        this.ownerName = ownerName;
        this.ownerEmail = ownerEmail;
        this.rollNo = rollNo;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

}