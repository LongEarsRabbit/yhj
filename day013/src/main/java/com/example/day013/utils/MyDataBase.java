package com.example.day013.utils;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.day013.bean.Banner;
import com.example.day013.dao.BannerDao;

/**
 * 时间:2022/6/1
 * 简述: TODO
 */
@Database(entities = Banner.class,version = 1,exportSchema = false)
public abstract class MyDataBase extends RoomDatabase {
    private static MyDataBase myDataBase;
    public abstract BannerDao dao();

    public static MyDataBase getMyDataBase(Context context){
        if(myDataBase == null){
            myDataBase = Room.databaseBuilder(context,MyDataBase.class,"shop")
                    .allowMainThreadQueries()
                    .build();
        }
        return myDataBase;
    }



}
