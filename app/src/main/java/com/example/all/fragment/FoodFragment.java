package com.example.all.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.all.App;
import com.example.all.R;
import com.example.all.adapter.FoodAdapter;
import com.example.all.bean.FoodBean;
import com.example.all.databinding.FraFoodBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2022/5/23
 */
public class FoodFragment extends Fragment {
    private FoodViewModel mViewModel;
    private FraFoodBinding binding;
    private FoodAdapter foodAdapter;

    public static FoodFragment getInstance(){
        return new FoodFragment();
    }


    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.fra_food, container, false);
        return binding.getRoot();

    }

    @Override
    public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this,new FoodViewModelFactory()).get(FoodViewModel.class);
        binding.rec.setLayoutManager(new LinearLayoutManager(getActivity()));
        mViewModel.getData();
        List<FoodBean.DataDTO> list = new ArrayList<>();
        foodAdapter = new FoodAdapter(list);
        binding.rec.setAdapter(foodAdapter);
        mViewModel.getMutableLiveData().observe(this, dataDTOS -> {
            list.clear();
            list.addAll(dataDTOS);
            foodAdapter.notifyDataSetChanged();
        });
        binding.setAc(this);
    }
    public void a(View v){
        Toast.makeText(getContext(), "a", Toast.LENGTH_SHORT).show();
    }
}
