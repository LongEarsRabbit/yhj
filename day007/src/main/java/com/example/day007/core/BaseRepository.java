package com.example.day007.core;

/**
 * @Date 2022/5/25
 */
public abstract class BaseRepository<M extends IModel> {
    protected M model;
    public BaseRepository(M model){
        this.model = model;
    }
}
