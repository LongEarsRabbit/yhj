package com.example.day013;

import androidx.lifecycle.LiveData;

import com.example.day013.bean.Banner;
import com.example.day013.datasource.BannerLocalDataSource;
import com.example.day013.datasource.BannerRemoteDataSource;
import com.fhz.utilsfhz.ApiResponse;

import java.util.List;

import javax.inject.Inject;

/**
 * 时间:2022/6/1
 * 简述: 选择网络获取 或者 本地获取
 */
public class BannerRepository {

    private static final String TAG = "yang";

    private BannerLocalDataSource localDataSource;
    private BannerRemoteDataSource remoteDataSource;

    @Inject
    public BannerRepository(BannerLocalDataSource localDataSource, BannerRemoteDataSource remoteDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }
    //远程
    public LiveData<ApiResponse<List<Banner>>> getBanner(){
        return remoteDataSource.getBanner();
    }




    //  本地  插入
    public void insertBanner(Banner... banners){
        localDataSource.insertBanner(banners);
    }

    //  本地  查询
    public List<Banner> getBanners(){
        return localDataSource.getBanners();

    }
}
