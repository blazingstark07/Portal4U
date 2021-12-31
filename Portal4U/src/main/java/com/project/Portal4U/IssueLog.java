package com.project.Portal4U;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class IssueLog {

    @Id
    private int ID;
    public ArrayList<String> names = new ArrayList<String>();
    public ArrayList<String> emails = new ArrayList<String>();

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public void addName(String name)
    {
        names.add(name);
    }

    public void addEmail(String email)
    {
        names.add(email);
    }

    public void setNames(ArrayList<String> names) {
        this.names = names;
    }

    public ArrayList<String> getEmails() {
        return emails;
    }

    public void setEmails(ArrayList<String> emails) {
        this.emails = emails;
    }
}
