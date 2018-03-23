package com.mudy.customview01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by mudy on 18/3/23.
 */
public class RectView extends View{
    //在java文件中创建的时候会调用这个方法
    public RectView(Context context) {
        super(context);
    }

    //在xml中使用的时候，会使用这个方法
    public RectView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = new RectF(0,0,100,80);
        Paint paint = new Paint();//画笔
//        canvas.drawRect(rectF,paint);//画一个矩形
        canvas.drawOval(rectF,paint);//椭圆 right与botton如果相等的话，则创建出来的是一个圆  但是现在创建出来的是有锯齿的,是在画笔中可以去掉
    }
}
