package com.example.day015;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * 时间:2022/6/6
 * 简述: TODO
 */
public class MyViewGroup extends ViewGroup {

    public MyViewGroup(Context context) {
        super(context);
    }

    public MyViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //控制子布局摆放
    }
}
