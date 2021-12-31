package com.project.Portal4U;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Issue {

    @Id
    private int ID;
    private static int currID = 20200;
    private int ping;
    private String details;
    private String longitude;
    private String latitude;
    private String status;
    private boolean waste;
    private boolean sewage;
    private boolean electricity;
    private boolean traffic;
    private boolean env;
    private boolean prop;
    private boolean other;
    private String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isWaste() {
        return waste;
    }

    public void setWaste(boolean waste) {
        this.waste = waste;
    }

    public boolean isSewage() {
        return sewage;
    }

    public void setSewage(boolean sewage) {
        this.sewage = sewage;
    }

    public boolean isElectricity() {
        return electricity;
    }

    public void setElectricity(boolean electricity) {
        this.electricity = electricity;
    }

    public boolean isTraffic() {
        return traffic;
    }

    public void setTraffic(boolean traffic) {
        this.traffic = traffic;
    }

    public boolean isEnv() {
        return env;
    }

    public void setEnv(boolean env) {
        this.env = env;
    }

    public boolean isProp() {
        return prop;
    }

    public void setProp(boolean prop) {
        this.prop = prop;
    }

    public boolean isOther() {
        return other;
    }

    public void setOther(boolean other) {
        this.other = other;
    }

    public int getID() {
        return ID;
    }

    public void setID() {
        this.ID = currID;
    }

    public int getPing() {
        return ping;
    }

    public void setPing(int ping) {
        this.ping = ping;
    }

    public void increasePing(int inc)
    {
        ping+=inc;
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

    public static int getCurrID() {
        return currID;
    }

    public static void setCurrID(int currID) {
        Issue.currID = currID;
    }

}
