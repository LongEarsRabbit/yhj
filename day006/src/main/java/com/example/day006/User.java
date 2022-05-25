package com.example.day006;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * @Date 2022/5/24
 */
@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    public int uid;
    @ColumnInfo(name = "first_name")
    public String first_name;
    @ColumnInfo(name = "last_name")
    public String lastName;
    @ColumnInfo(defaultValue = "-1")
    public int age;

    public User(String first_name, String lastName) {
        this.first_name = first_name;
        this.lastName = lastName;
    }

}
