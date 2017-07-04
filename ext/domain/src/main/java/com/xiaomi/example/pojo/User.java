package com.xiaomi.example.pojo;

import java.io.Serializable;

/**
 * Created by mi on 2017/2/13.
 */


public class User implements Serializable{
    private int userId;
    private String userName;
    private String email;
    private String gender;
    private String password;

    public User() {
    }

    public User(int id, String name, String password) {
        this.userId = id;
        this.userName = name;
        this.password = password;
    }

    public User(int id, String name, String email, String gender, String password) {
        this.userId = id;
        this.userName = name;
        this.email = email;
        this.gender = gender;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int id){
        userId = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
