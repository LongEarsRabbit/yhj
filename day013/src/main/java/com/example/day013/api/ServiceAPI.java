package com.example.day013.api;

import androidx.lifecycle.LiveData;

import com.example.day013.bean.Banner;
import com.fhz.utilsfhz.ApiResponse;

import java.util.List;

import retrofit2.http.GET;

/**
 * 时间:2022/6/1
 * 简述: bannerAPI
 */
public interface ServiceAPI {
    String BASE_URL = "http://www.fenghongzhang.com:9999/";

    @GET("/banner/getImages")
    LiveData<ApiResponse<List<Banner>>> getBanner();
}
