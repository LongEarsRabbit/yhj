package com.example.day015;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * 时间:2022/6/5
 * 简述: 自定义view
 */
public class MyTextView extends View {

    int defSizeW = 0;
    int defSizeH = 0;

    public MyTextView(Context context) {
        super(context);
        init(context, null);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context,@Nullable AttributeSet attrs) {
        Paint paint = new Paint();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.BLACK);

    }
    //必须要重写 计算自己包裹内容的大小
    //源码里的warp和match是一个逻辑
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //宽
        int mode = MeasureSpec.getMode(widthMeasureSpec);
        int size = MeasureSpec.getSize(widthMeasureSpec);
        switch (mode){
            case MeasureSpec.UNSPECIFIED:
                defSizeW = size;
                break;
            case MeasureSpec.AT_MOST:
                defSizeW = 500;  //根据内容大小
                break;
            case MeasureSpec.EXACTLY:
                defSizeW = size;
                break;
        }
        //高
        int mode1 = MeasureSpec.getMode(heightMeasureSpec);
        int size1 = MeasureSpec.getSize(heightMeasureSpec);
        switch (mode1){
            case MeasureSpec.UNSPECIFIED:   //最大值
                defSizeH = size1;
                break;
            case MeasureSpec.AT_MOST: //不指定测量模式
                defSizeH = 500;
                break;
            case MeasureSpec.EXACTLY: //精准固定值固定值
                defSizeH = size1;
                break;
        }
        int W = MeasureSpec.makeMeasureSpec(defSizeW, mode);
        int H = MeasureSpec.makeMeasureSpec(defSizeH, mode1);
        setMeasuredDimension(W,H);

    }
}
