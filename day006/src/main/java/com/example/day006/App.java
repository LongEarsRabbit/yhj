package com.example.day006;

import android.app.Application;
import android.content.Context;

/**
 * @Date 2022/5/24
 */
public class App extends Application {
    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
