package com.example.httpMicroservice;

public class RegistrationService {
    private String companyName;
    private String ownerName;
    private String rollNo;
    private String ownerEmail;
    private String accessCode;

    public RegistrationService(String companyName, String ownerName, String rollNo, String ownerEmail, String accessCode) {
        this.companyName = companyName;
        this.ownerName = ownerName;
        this.rollNo = rollNo;
        this.ownerEmail = ownerEmail;
        this.accessCode = accessCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }
}