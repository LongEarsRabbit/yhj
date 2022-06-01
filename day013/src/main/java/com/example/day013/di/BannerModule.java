package com.example.day013.di;

import android.content.Context;

import com.example.day013.dao.BannerDao;
import com.example.day013.utils.MyDataBase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

/**
 * 时间:2022/6/1
 * 简述: TODO
 */
@Module
@InstallIn(SingletonComponent.class)
public class BannerModule {

    @Singleton
    @Provides
    public MyDataBase getMyDataBase(@ApplicationContext Context context){
        return MyDataBase.getMyDataBase(context);
    }

    @Provides
    public BannerDao getBannerDao(MyDataBase myDataBase){
        return myDataBase.dao();
    }
}
