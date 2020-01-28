package com.reap.project.reap.model;


import javax.persistence.*;

@Entity
@Table(name = "badges")
public class UserBadges {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    int id;
    @Column(name = "badge_name")
    String badgeType;
    @Column(name ="badge_count")
    int badgeCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return badgeType;
    }

    public void setType(String badgeType) {
        this.badgeType = badgeType;
    }

    public int getCount() {
        return badgeCount;
    }

    public void setCount(int count) {
        this.badgeCount = count;
    }

    public UserBadges(String badgeType, int badgeCount) {
        this.badgeType = badgeType;
        this.badgeCount = badgeCount;
    }

    public UserBadges() {
    }

    @Override
    public String toString() {
        return "UserBadges{" +
                "id=" + id +
                ", type='" + badgeType + '\'' +
                ", count=" + badgeCount +
                '}';
    }

    @ManyToOne
    User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
