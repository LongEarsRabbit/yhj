package com.example.all.fragment;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.all.foodModel.FoodModel;

import org.jetbrains.annotations.NotNull;

/**
 * @Date 2022/5/23
 */
public class FoodViewModelFactory implements ViewModelProvider.Factory {
    @NonNull
    @NotNull
    @Override
    public <T extends ViewModel> T create(@NonNull @NotNull Class<T> modelClass) {
        return (T) new FoodViewModel(new FoodModel());
    }
}
