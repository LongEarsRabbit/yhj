package com.example.day011;

import javax.inject.Inject;

/**
 * @Date 2022/5/31
 */
public class User {
    public String name;


    public User() {
    }

    @Inject
    public User(String name) {
        this.name = name;
    }

}
