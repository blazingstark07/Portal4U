package com.project.Portal4U;

import javax.persistence.Entity;

public class UserIssue {
    private String name;
    private String email;
    private String details;
    private String longitude;
    private String latitude;
    private String issue1;
    private String issue2;
    private String issue3;
    private String issue4;
    private String issue5;
    private String issue6;
    private String issue7;

    public String getIssue1() {
        return issue1;
    }

    public void setIssue1(String issue1) {
        this.issue1 = issue1;
    }

    public String getIssue2() {
        return issue2;
    }

    public void setIssue2(String issue2) {
        this.issue2 = issue2;
    }

    public String getIssue3() {
        return issue3;
    }

    public void setIssue3(String issue3) {
        this.issue3 = issue3;
    }

    public String getIssue4() {
        return issue4;
    }

    public void setIssue4(String issue4) {
        this.issue4 = issue4;
    }

    public String getIssue5() {
        return issue5;
    }

    public void setIssue5(String issue5) {
        this.issue5 = issue5;
    }

    public String getIssue6() {
        return issue6;
    }

    public void setIssue6(String issue6) {
        this.issue6 = issue6;
    }

    public String getIssue7() {
        return issue7;
    }

    public void setIssue7(String issue7) {
        this.issue7 = issue7;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "UserIssue{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", details='" + details + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", issue1='" + issue1 + '\'' +
                ", issue2='" + issue2 + '\'' +
                ", issue3='" + issue3 + '\'' +
                ", issue4='" + issue4 + '\'' +
                ", issue5='" + issue5 + '\'' +
                ", issue6='" + issue6 + '\'' +
                ", issue7='" + issue7 + '\'' +
                '}';
    }
}
