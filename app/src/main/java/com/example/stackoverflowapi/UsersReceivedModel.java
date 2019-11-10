package com.example.stackoverflowapi;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UsersReceivedModel {

    @SerializedName("items")
    private List<User> users;

    public List<User> getUsers(){ return users; }

    public void setUsers(List<User> users) { this.users = users; }
}
