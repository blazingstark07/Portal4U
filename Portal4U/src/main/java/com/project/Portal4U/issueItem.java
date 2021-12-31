package com.project.Portal4U;

import java.util.ArrayList;
import java.util.List;

public class issueItem {

    private int id;
    private String status;
    private String location;
    public List<String> tags;
    private int ping;
    private String comment;

    @Override
    public String toString() {
        return "issueList{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", location='" + location + '\'' +
                ", tags=" + tags +
                ", ping=" + ping +
                ", comment='" + comment + '\'' +
                '}';
    }

    public void addTag(String tag){
        tags.add(tag);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public int getPing() {
        return ping;
    }

    public void setPing(int ping) {
        this.ping = ping;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
