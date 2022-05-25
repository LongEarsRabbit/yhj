package com.example.day007;

import android.util.Log;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.day007.bean.Food;
import com.example.day007.core.BaseActivity;
import com.example.day007.databinding.ActivityMainBinding;
import com.fhz.utilsfhz.ApiResponse;

import java.util.List;

public class MainActivity extends BaseActivity<MainViewModel, ActivityMainBinding> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        //初始化数据
        mViewModel.getFood().observe(this, new Observer<ApiResponse<List<Food>>>() {
            @Override
            public void onChanged(ApiResponse<List<Food>> listApiResponse) {
                Log.i("TAG--", "onChanged: "+listApiResponse.data.size());
            }
        });
    }

    @Override
    protected MainViewModel createViewModel() {
        return new ViewModelProvider(this,new MyMainViewModelFactory()).get(MainViewModel.class);
    }
}