package com.sales.online.games.salesonlinegames.Domain.Core;

import com.sales.online.games.salesonlinegames.Domain.Core.Enuns.UserType;

public class User {
    private long userId;
    private String username;
    private String password;
    private UserType userType;
    private long customerId;

    public User(){}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
