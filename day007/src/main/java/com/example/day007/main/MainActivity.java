package com.example.day007.main;

import android.util.Log;

import androidx.annotation.NonNull;
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
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;

import org.jetbrains.annotations.NotNull;

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
        getData();
        mDataBinding.refresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull @NotNull RefreshLayout refreshLayout) {
//                getData();
                mDataBinding.refresh.finishLoadMore();
            }
        });

        foodShowAdapter = new FoodShowAdapter(R.layout.item_show, list);
        mDataBinding.rec.setAdapter(foodShowAdapter);
        FoodDataBase.getInstance().foodDao().loadAll().observe(this, foods -> {
            Log.i("foods", "发生改变");
            for (Food fooda : foods) {
                Log.i("foods", fooda.getCategoryName());
            }
        });

    }

    @Override
    protected MainViewModel createViewModel() {
        return new ViewModelProvider(this,new MyMainViewModelFactory()).get(MainViewModel.class);
    }

    public void getData(){
        mViewModel.getFood().observe(MainActivity.this, new Observer<ApiResponse<List<Food>>>() {
            @Override
            public void onChanged(ApiResponse<List<Food>> listApiResponse) {
                list.addAll(listApiResponse.data);
                Log.i("size--", "onChanged: "+list.size());
                foodShowAdapter.notifyDataSetChanged();
            }
        });
    }
}