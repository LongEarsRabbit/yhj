package com.example.day011;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "yang";

    @Z
    @Inject
    User user;

    @S
    @Inject
    User user1;

//    @Inject
//    Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //带参数  inject放在有参构造上
        DaggerUserComponent.builder().userModule(new UserModule()).build().inject(this);
//        DaggerUserComponent.builder().studentModule(new StudentModule()).build().inject(this);
        Log.i(TAG, "onCreate: "+user.name);
        Log.i(TAG, "onCreate: "+user1.name);
//        Log.i(TAG, "onCreate: "+student.age);
    }

    //不带参数 inject注释放在无参构造上
    public void noString(){
        DaggerUserComponent.builder().build().inject(this);
        user.name = "张三";
        Log.i(TAG, "onCreate: "+user.name);
    }
}