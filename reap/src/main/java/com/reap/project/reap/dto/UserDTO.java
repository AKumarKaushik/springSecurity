package com.reap.project.reap.dto;


import com.reap.project.reap.model.User;

import java.util.ArrayList;
import java.util.List;


public class UserDTO {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    private String email;

    private String firstname;

    private String lastname;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    private int active;

    public UserDTO() {

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

    private String role;

    public int getGoldBadgeCount() {
        return goldBadgeCount;
    }

    public void setGoldBadgeCount(int goldBadgeCount) {
        this.goldBadgeCount = goldBadgeCount;
    }

    public int getSilverBadgeCount() {
        return silverBadgeCount;
    }

    public void setSilverBadgeCount(int silverBadgeCount) {
        this.silverBadgeCount = silverBadgeCount;
    }

    public int getBronzeBadgeCount() {
        return bronzeBadgeCount;
    }

    public void setBronzeBadgeCount(int bronzeBadgeCount) {
        this.bronzeBadgeCount = bronzeBadgeCount;
    }

    private int goldBadgeCount;
    private int silverBadgeCount;
    private int bronzeBadgeCount;

    public static  List<UserDTO> createDTO(List<User >userList){
        List<UserDTO> userDTOList = new ArrayList<UserDTO>();
        for(User user : userList){
            UserDTO userDTO= new UserDTO();
            userDTOList.add(userDTO);
            userDTO.setRole(user.getRoles().get(0).getRole());
            userDTO.setGoldBadgeCount(user.getBadges().get(0).getCount());
            userDTO.setSilverBadgeCount(user.getBadges().get(1).getCount());
            userDTO.setBronzeBadgeCount(user.getBadges().get(2).getCount());
            userDTO.setId(user.getId());
            userDTO.setActive(user.getActive());
            userDTO.setEmail(user.getEmail());
            userDTO.setFirstname(user.getFirstname());
            userDTO.setLastname(user.getLastname());
            userDTO.setPassword(user.getPassword());
        }
        return userDTOList;
    }
}
