package com.example.day006;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button addOne;
    private Button selectAll;
    private Button change;
    private Button delete;
    private Button selectMo;





    private AppDataBase appDataBase;
    private UserDao userDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        addOne = (Button) findViewById(R.id.add_one);
        selectAll = (Button) findViewById(R.id.select_all);
        change = (Button) findViewById(R.id.change);
        delete = (Button) findViewById(R.id.delete);
        selectMo = (Button) findViewById(R.id.select_mo);

        addOne.setOnClickListener(this::onClick);
        selectAll.setOnClickListener(this::onClick);
        change.setOnClickListener(this::onClick);
        delete.setOnClickListener(this::onClick);
        selectMo.setOnClickListener(this::onClick);

        appDataBase = AppDataBase.getInstance();
        userDao = appDataBase.userDao();


        userDao.getAllByLiveData().observe(this, users -> {
            for (User user : users) {
                Log.i("TAG--", user.uid+"   "+user.first_name);
            }
        });


    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.select_all:
                List<User> all = userDao.getAll();
                for (User user : all) {
                    Log.i("TAG--", user.first_name+"");
                }
                break;
            case R.id.add_one:
                User user = new User("张三","李四");
                userDao.insertAl(user);
                break;
            case R.id.change:
                User user1 = new User("wahh","王四");
                user1.uid = 5;
                userDao.update(user1);
                break;
            case R.id.delete:
                User user2 = new User("wahh","王四");
                user2.uid = 5;
                userDao.delete(user2);
                break;
            case R.id.select_mo:
                List<User> users = userDao.select_mo("%张%");
                for (User user3 : users) {
                    Log.i("TAG---", user3.first_name);
                }
                break;
        }
    }
}