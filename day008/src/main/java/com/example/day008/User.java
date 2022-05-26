package com.example.day008;

/**
 * @Date 2022/5/26
 */
public class User {
    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String name;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
