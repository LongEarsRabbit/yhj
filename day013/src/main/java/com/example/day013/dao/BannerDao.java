package com.example.day013.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.day013.bean.Banner;

import java.util.List;

/**
 * 时间:2022/6/1
 * 简述: TODO
 */
@Dao
public interface BannerDao {
    //插入
    @Insert
    void insertBanners(Banner... banners);//可以传入一个数组

    //查询
    @Query("select * from banner")
    List<Banner> getBanners();






}
