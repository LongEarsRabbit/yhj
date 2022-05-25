package com.example.day007.core;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/**
 * @Date 2022/5/25
 */
public abstract class BaseActivity<VM extends BaseViewModel,DB extends ViewDataBinding> extends AppCompatActivity {
    protected VM mViewModel;
    protected DB mDataBinding;

    protected abstract int getLayoutId();
    protected abstract void initData();
    protected abstract VM createViewModel();

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataBinding = DataBindingUtil.setContentView(this,getLayoutId());
        mViewModel = createViewModel();
        initData();

    }
}
