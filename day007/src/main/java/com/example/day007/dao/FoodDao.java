package com.example.day007.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.day007.bean.Food;

import java.util.List;

/**
 * @Date 2022/5/26
 */
@Dao
public interface FoodDao {
    @Query("SELECT * FROM food")
    LiveData<List<Food>> loadAll();
    @Insert
    void addFood(Food food);
    @Query("select * from food where id = :id")
    int selectIsCun(String id);
    @Delete
    void deleteById(Food food);
}




