package com.example.day00502.foodModel;

import androidx.lifecycle.LiveData;

import com.example.day00502.api.API;
import com.example.day00502.bean.FoodBean;
import com.example.day00502.retrofit.RetrofitManager;

import io.reactivex.Observer;

/**
 * @Date 2022/5/23
 */
public class FoodModel {

    public void getFoodData(Observer<FoodBean> observer){
        LiveData<FoodBean> foodData = RetrofitManager.getInstance().getRetrofit().create(API.class)
                .getFoodData();
    }
}
