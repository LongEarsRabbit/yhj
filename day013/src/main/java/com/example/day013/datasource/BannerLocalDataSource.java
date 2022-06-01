package com.example.day013.datasource;

import com.example.day013.bean.Banner;
import com.example.day013.dao.BannerDao;
import com.example.day013.utils.MyDataBase;

import java.util.List;

import javax.inject.Inject;

/**
 * 时间:2022/6/1
 * 简述: 本地数据源 -> 操作数据库
 */
public class BannerLocalDataSource {

    private MyDataBase myDataBase;
    private BannerDao bannerDao;

    public BannerLocalDataSource(){

    }
    @Inject
    public BannerLocalDataSource(MyDataBase myDataBase, BannerDao bannerDao) {
        this.myDataBase = myDataBase;
        this.bannerDao = bannerDao;
    }
    //插入
    public void insertBanner(Banner... banners){
        bannerDao.insertBanners(banners);
    }

    //查询
    public List<Banner> getBanners(){
        return bannerDao.getBanners();
    }


}
