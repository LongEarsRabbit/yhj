package com.example.day00502.api;

import androidx.lifecycle.LiveData;

import com.example.day00502.bean.FoodBean;

import retrofit2.http.GET;

/**
 * @Date 2022/5/23
 */
public interface API {

    @GET("ios/cf/dish_list.php?stage_id=1&limit=20&page=1")
    LiveData<FoodBean> getFoodData();
}
