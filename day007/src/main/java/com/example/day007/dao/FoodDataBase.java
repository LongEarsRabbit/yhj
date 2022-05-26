package com.example.day007.dao;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.day007.App;
import com.example.day007.bean.Food;

/**
 * @Date 2022/5/26
 */
@Database(entities = {Food.class},version = 1)
public abstract class FoodDataBase extends RoomDatabase {
    public abstract FoodDao foodDao();
    private static FoodDataBase foodDataBase;
    public static FoodDataBase getInstance(){
        if(foodDataBase == null){
            foodDataBase =  Room
                    .databaseBuilder(App.context, FoodDataBase.class, "database-food")
                    .allowMainThreadQueries()
                    .build();
        }
        return foodDataBase;
    }
}
