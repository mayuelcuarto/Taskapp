package com.example.zambo.taskapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Cristhian on 20-12-2017.
 */

public class UserLogin {
    private String email;
    private String password;
    private boolean getHash;

    public UserLogin(){}

    public UserLogin(String email, String password, boolean getHash){
        this.email = email;
        this.password = password;
        this.getHash = getHash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGetHash(boolean getHash){
        this.getHash = getHash;
    }

    public boolean isGetHash(){
        return getHash;
    }
}
