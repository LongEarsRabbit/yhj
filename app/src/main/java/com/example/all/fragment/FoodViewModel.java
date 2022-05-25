package com.example.all.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.all.bean.FoodBean;
import com.example.all.foodModel.FoodModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @Date 2022/5/23
 */
public class FoodViewModel  extends ViewModel{
    private MutableLiveData<List<FoodBean.DataDTO>> mutableLiveData = new MutableLiveData<>();
    public MutableLiveData<List<FoodBean.DataDTO>> getMutableLiveData(){
        return mutableLiveData;
    }
    public void setMutableLiveData(List<FoodBean.DataDTO> data){
        mutableLiveData.postValue(data);
    }

    public FoodViewModel(FoodModel foodModel){
        this.foodModel = foodModel;
    }

    private FoodModel foodModel;

    public void getData(){
        foodModel.getFoodData(new Observer<FoodBean>() {
            @Override
            public void onSubscribe(@NotNull Disposable d) {

            }

            @Override
            public void onNext(@NotNull FoodBean foodBean) {
                setMutableLiveData(foodBean.getData());
            }

            @Override
            public void onError(@NotNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }


}
