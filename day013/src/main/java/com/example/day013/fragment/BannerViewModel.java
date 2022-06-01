package com.example.day013.fragment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.day013.BannerRepository;
import com.example.day013.bean.Banner;
import com.fhz.utilsfhz.ApiResponse;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class BannerViewModel extends ViewModel {
    private BannerRepository repository;

    @Inject
    public BannerViewModel(BannerRepository repository) {
        this.repository = repository;
    }
    //远程方法
    public LiveData<ApiResponse<List<Banner>>> getBanner(){
        return repository.getBanner();
    }


}