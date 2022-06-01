package com.example.day012;

import javax.inject.Inject;

/**
 * @Date 2022/5/31
 */
public class User {
    public String name;

    public String address;

    public User() {

    }

    @Inject
    public User(String name) {
        this.name = name;
    }

    public User(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
