package com.example.all.foodModel;

import com.example.all.api.API;
import com.example.all.bean.FoodBean;
import com.example.all.retrofit.RetrofitManager;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @Date 2022/5/23
 */
public class FoodModel {
    public void getFoodData(Observer<FoodBean> observer){
        RetrofitManager.getInstance().getRetrofit().create(API.class)
                .getFoodData().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(observer);
    }
}
