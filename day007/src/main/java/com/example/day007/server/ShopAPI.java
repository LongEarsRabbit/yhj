package com.example.day007.server;

import androidx.lifecycle.LiveData;

import com.example.day007.bean.Food;
import com.fhz.utilsfhz.ApiResponse;

import java.util.List;

import retrofit2.http.GET;

/**
 * @Date 2022/5/25
 */
public interface ShopAPI {

    String BASE_URL = "http://www.fenghongzhang.com:9999/";

    @GET("category/getType?type=1")
    LiveData<ApiResponse<List<Food>>> getData();

}
