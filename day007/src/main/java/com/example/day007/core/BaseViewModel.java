package com.example.day007.core;

import androidx.lifecycle.ViewModel;

/**
 * @Date 2022/5/25
 */
public class BaseViewModel<R extends BaseRepository> extends ViewModel {
    protected R repository;
    public BaseViewModel(R repository){
        this.repository = repository;
    }
}
