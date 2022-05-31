package com.example.day012;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;

/**
 * @Date 2022/5/31
 */
@Module
@InstallIn(ActivityComponent.class)
public class UserModule {

    @Provides
    @Z
    public User getUser(){
        return new User("刘");
    }

    @Provides
    @S
    public User getUser2(){
        return new User("三");
    }
}
