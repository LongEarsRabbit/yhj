package com.example.day007.main;

import android.util.Log;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.day007.R;
import com.example.day007.adapter.FoodShowAdapter;
import com.example.day007.bean.Food;
import com.example.day007.core.BaseActivity;
import com.example.day007.dao.FoodDataBase;
import com.example.day007.databinding.ActivityMainBinding;
import com.fhz.utilsfhz.ApiResponse;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<MainViewModel, ActivityMainBinding> {
    private List<Food> list = new ArrayList<>();
    private FoodShowAdapter foodShowAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        //初始化数据

        mDataBinding.rec.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        foodShowAdapter = new FoodShowAdapter(R.layout.item_show, list);
        FoodDataBase.getInstance().foodDao().loadAll().observe(this, foods -> {
            Log.i("foods", "发生改变");
            for (Food fooda : foods) {
                Log.i("foods", fooda.getCategoryName());
            }
        });
        mViewModel.getFood().observe(this, new Observer<ApiResponse<List<Food>>>() {
            @Override
            public void onChanged(ApiResponse<List<Food>> listApiResponse) {
                list.clear();
                list.addAll(listApiResponse.data);
                mDataBinding.rec.setAdapter(foodShowAdapter);
                foodShowAdapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    protected MainViewModel createViewModel() {
        return new ViewModelProvider(this,new MyMainViewModelFactory()).get(MainViewModel.class);
    }
}