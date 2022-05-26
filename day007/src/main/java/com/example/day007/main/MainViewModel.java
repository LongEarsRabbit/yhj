package com.example.day007.main;

import androidx.lifecycle.LiveData;

import com.example.day007.bean.Food;
import com.example.day007.core.BaseViewModel;
import com.fhz.utilsfhz.ApiResponse;

import java.util.List;

/**
 * @Date 2022/5/25
 */
public class MainViewModel extends BaseViewModel<MainRepository> {

    public MainViewModel(MainRepository repository) {
        super(repository);
    }
    public LiveData<ApiResponse<List<Food>>> getFood(){
        return repository.getFood();
    }
}
