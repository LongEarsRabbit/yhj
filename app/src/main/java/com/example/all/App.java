package com.example.all;

import android.app.Application;

/**
 * @Date 2022/5/23
 */
public class App extends Application {
    private static Application application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;

    }
    public static Application getApp(){
        return application;
    }
}
