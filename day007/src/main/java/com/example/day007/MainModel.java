package com.example.day007;

import androidx.lifecycle.LiveData;

import com.example.day007.bean.Food;
import com.example.day007.core.IModel;
import com.example.day007.server.ShopAPI;
import com.example.day007.utils.RetrofitManager;
import com.fhz.utilsfhz.ApiResponse;

import java.util.List;

/**
 * @Date 2022/5/25
 */
public class MainModel implements IModel {

    public LiveData<ApiResponse<List<Food>>> getFood(){
        return RetrofitManager.getInstance().getRetrofit().create(ShopAPI.class).getData();
    }


}
