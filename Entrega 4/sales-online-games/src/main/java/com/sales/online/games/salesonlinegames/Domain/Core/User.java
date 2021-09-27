package com.sales.online.games.salesonlinegames.Domain.Core;

public class User {
    private long userId;
    private String username;
    private String password;

<<<<<<< HEAD
    public User(){}
=======
    public User() { }
>>>>>>> c095aa8c479a5bc3c9e2f9e11484e73840db3c34

    public User(String username, String password) {
        this.username = username;
        this.password = password;
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
