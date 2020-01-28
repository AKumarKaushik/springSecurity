package com.reap.project.reap.dto;

import com.reap.project.reap.model.Role;
import com.reap.project.reap.model.User;
import com.reap.project.reap.model.UserBadges;

public class AdminDTO {

    private int id;
    private int active;
    private String role;
    private int goldCount;
    private int silverCount;
    private int bronzeCount;

    public int getGoldCount() {
        return goldCount;
    }

    public void setGoldCount(int goldCount) {
        this.goldCount = goldCount;
    }

    public int getSilverCount() {
        return silverCount;
    }

    public void setSilverCount(int silverCount) {
        this.silverCount = silverCount;
    }

    public int getBronzeCount() {
        return bronzeCount;
    }

    public void setBronzeCount(int bronzeCount) {
        this.bronzeCount = bronzeCount;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AdminDTO{" +
                "id=" + id +
                ", active='" + active + '\'' +
                ", role='" + role + '\'' +
                ", goldCount='" + goldCount + '\'' +
                ", silverCount='" + silverCount + '\'' +
                ", bronzeCount='" + bronzeCount + '\'' +
                '}';
    }
}
