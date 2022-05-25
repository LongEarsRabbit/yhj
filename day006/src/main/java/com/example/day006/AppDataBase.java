package com.example.day006;

import androidx.room.AutoMigration;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * @Date 2022/5/24
 */
@Database(entities = {User.class},version = 3,autoMigrations = @AutoMigration(from = 2,to = 3))
public abstract class AppDataBase extends RoomDatabase {
    public abstract UserDao userDao();

    private static AppDataBase appDataBase;
    public static AppDataBase getInstance(){
        if(appDataBase == null){
            appDataBase = Room.databaseBuilder(App.context,AppDataBase.class,"database_user")
                    .allowMainThreadQueries()
                    .build();
        }
        return appDataBase;
    }

}














