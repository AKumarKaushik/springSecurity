package com.reap.project.reap.model;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "email")
    @NotNull
    @Size(min = 2, max = 35, message = "Email address must be of length 2 to 20")
    @Email
    private String email;


    @Column(name = "firstname")
    @NotNull
    @Size(min = 2, max = 15,message = "First name must be of length 2 to 10")
    private String firstname;

    @Column(name = "lastname")
    @NotNull
    @Size(min = 2, max = 15,message = "Last name must be of length 2 to 10")
    private String lastname;

    @Column(name = "password")
    @NotNull
    @Size(min = 2, max = 10,message = "Password must be of length 2 to 10")
    private String password;

    @Column(name = "active")
    private int active;

    @Column(name = "completeName")
    private String userCompleteName;

    public String getUserCompleteName() {
        return userCompleteName;
    }

    public void setUserCompleteName(String userCompleteName) {
        this.userCompleteName = userCompleteName;
    }

    @Column(name="goldBadgesReceived")
    private int goldBadgesReceived;
    @Column(name = "silverBadgesReceived")
    private int silverBadgesReceived;
    @Column(name = "bronzeBadgesReceived")
    private int bronzeBadgesReceived;

    public int getGoldBadgesReceived() {
        return goldBadgesReceived;
    }

    public void setGoldBadgesReceived(int goldBadgesReceived) {
        this.goldBadgesReceived = goldBadgesReceived;
    }

    public int getSilverBadgesReceived() {
        return silverBadgesReceived;
    }

    public void setSilverBadgesReceived(int silverBadgesReceived) {
        this.silverBadgesReceived = silverBadgesReceived;
    }

    public int getBronzeBadgesReceived() {
        return bronzeBadgesReceived;
    }

    public void setBronzeBadgesReceived(int bronzeBadgesReceived) {
        this.bronzeBadgesReceived = bronzeBadgesReceived;
    }

    public User(int id, String email, String firstname, String lastname, String password, int active) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.active = active;
        this.id = id;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +                "id=" + id +
                ", email='" + email + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(joinColumns = @JoinColumn(name="user_id")
            ,inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_badges", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "badges_id"))
    List<UserBadges> badges;

    public List<UserBadges> getBadges() {
        return badges;
    }

    public void setBadges(List<UserBadges> badges) {
        this.badges = badges;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_recognize",joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "recognize_id"))
    List<UserRecognize> recognizeList;

    public List<UserRecognize> getRecognizeList() {
        return recognizeList;
    }

    public void setRecognizeList(List<UserRecognize> recognizeList) {
        this.recognizeList = recognizeList;
    }
}
