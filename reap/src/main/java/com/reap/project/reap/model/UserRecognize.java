package com.reap.project.reap.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "recognize")
public class UserRecognize {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String newersEmail;

    private String badgeType;

    private String coreValue;

    private String appreciationMessage;

    private int appreciatedByUserId;

    private String newersName;

    private String appreciatedByUserName;

    Date timeStamp;

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getAppreciatedByUserName() {
        return appreciatedByUserName;
    }

    public void setAppreciatedByUserName(String appreciatedByUserName) {
        this.appreciatedByUserName = appreciatedByUserName;
    }


    public int getAppreciatedByUserId() {
        return appreciatedByUserId;
    }

    public void setAppreciatedByUserId(int appreciatedByUserId) {
        this.appreciatedByUserId = appreciatedByUserId;
    }

    public String getNewersEmail() {
        return newersEmail;
    }

    public void setNewersEmail(String newersEmail) {
        this.newersEmail = newersEmail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBadgeType() {
        return badgeType;
    }

    public void setBadgeType(String badgeType) {
        this.badgeType = badgeType;
    }

    public String getCoreValue() {
        return coreValue;
    }

    public void setCoreValue(String coreValue) {
        this.coreValue = coreValue;
    }

    public String getAppreciationMessage() {
        return appreciationMessage;
    }

    public void setAppreciationMessage(String appreciationMessage) {
        this.appreciationMessage = appreciationMessage;
    }

    public String getNewersName() {
        return newersName;
    }

    public void setNewersName(String newersName) {
        this.newersName = newersName;
    }

    @Override
    public String toString() {
        return "UserRecognize{" +
                "id=" + id +
                ", newersEmail='" + newersEmail + '\'' +
                ", badgeType='" + badgeType + '\'' +
                ", coreValue='" + coreValue + '\'' +
                ", appreciationMessage='" + appreciationMessage + '\'' +
                ", appreciatedByUserId=" + appreciatedByUserId +
                ", newersName='" + newersName + '\'' +
                ", loggedInUser=" + loggedInUser +
                '}';
    }

    @ManyToOne
    private User loggedInUser;

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
}
