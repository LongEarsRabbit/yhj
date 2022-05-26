package com.example.day008;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity{
    @RequiresApi(api = 31)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Class clazz = User.class;
//        String packageName = clazz.getSimpleName();
//        Log.i("TAG--", "onCreate: "+packageName);
        try {
            //通过字节码创建对象
            Class<?> aClass = Class.forName("com.example.day008.User");
            User user = (User) aClass.newInstance();
//            user.name = "刘继权";
//            System.out.println(user.name);

            //获取所有的字段 （私有拿不到）
//            Field[] fields = aClass.getFields();
//            Log.i("TAG--",  fields.length+"");

            //获取所有的声明的字段
//            Field[] declaredFields = aClass.getDeclaredFields();
//            Log.i("TAG--", declaredFields.length+"");

            //根据指定的名称获取指定的字段
            Field nameField = aClass.getField("name");
            nameField.set(user,"张三");
            Log.i("TAG--", user.name);
            Field address = aClass.getDeclaredField("address");
            address.setAccessible(true);
            address.set(user,"哇哈哈工厂");
            Log.i("TAG--", user.getAddress());



        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}