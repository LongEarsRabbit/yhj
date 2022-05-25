package com.example.day007;

import androidx.lifecycle.LiveData;

import com.example.day007.bean.Food;
import com.example.day007.core.BaseRepository;
import com.fhz.utilsfhz.ApiResponse;

import java.util.List;

/**
 * @Date 2022/5/25
 */
public class MainRepository extends BaseRepository<MainModel> {

    public MainRepository(MainModel model) {
        super(model);
    }
    public LiveData<ApiResponse<List<Food>>> getFood(){
        return model.getFood();
    }
}
