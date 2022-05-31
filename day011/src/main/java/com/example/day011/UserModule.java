package com.example.day011;

import dagger.Module;
import dagger.Provides;

/**
 * @Date 2022/5/31
 */
@Module
public class UserModule {
    @Provides
    @Z
    public User getUser(){
        return new User("兄奥秘");
    }

    @Provides
    @S
    public User getUser1(){
        return new User("兄奥秘22");
    }
}
