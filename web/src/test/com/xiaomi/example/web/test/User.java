package com.xiaomi.example.web.test;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by liujin on 2017/7/18.
 */
public class User implements Serializable, Cloneable {
    private String userName;
    private String password;
    private Date birthday;


    public User(String userName, String password, Date birthday) {
        super();
        this.userName = userName;
        this.password = password;
        this.birthday = birthday;
    }



    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!userName.equals(user.userName)) return false;
        if (!password.equals(user.password)) return false;
        return birthday.equals(user.birthday);
    }

    @Override
    public int hashCode() {
        int result = userName.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + birthday.hashCode();
        return result;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                '}';
    }


}
