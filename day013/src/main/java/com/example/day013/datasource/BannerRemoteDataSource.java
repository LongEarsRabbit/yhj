package com.example.day013.datasource;

import androidx.lifecycle.LiveData;

import com.example.day013.api.ServiceAPI;
import com.example.day013.bean.Banner;
import com.example.day013.utils.RetrofitManager;
import com.fhz.utilsfhz.ApiResponse;

import java.util.List;

import javax.inject.Inject;

/**
 * 时间:2022/6/1
 * 简述: 远程数据源
 */
public class BannerRemoteDataSource {

    @Inject
    public BannerRemoteDataSource() {

    }

    public LiveData<ApiResponse<List<Banner>>> getBanner(){
        return RetrofitManager.getInstance().getRetrofit().create(ServiceAPI.class)
                .getBanner();
    }
}
