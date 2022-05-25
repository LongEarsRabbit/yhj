package com.example.day006;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * @Date 2022/5/24
 */
@Dao
public interface UserDao {
    @Query("select * from user")
    List<User> getAll();

    @Query("select * from user")
    LiveData<List<User>> getAllByLiveData();

    @Insert
    void insertAl(User... users);

    @Update
    void update(User user);

    @Delete
    void delete(User user);

    @Query("select * from user where first_name like :msg")
    List<User> select_mo(String msg);
}
