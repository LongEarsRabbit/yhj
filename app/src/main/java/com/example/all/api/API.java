package com.example.all.api;

import androidx.lifecycle.LiveData;

import com.example.all.bean.FoodBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @Date 2022/5/23
 */
public interface API {

    @GET("ios/cf/dish_list.php?stage_id=1&limit=20&page=1")
    Observable<FoodBean> getFoodData();
}
