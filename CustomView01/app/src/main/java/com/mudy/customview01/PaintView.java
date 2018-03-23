package com.mudy.customview01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by mudy on 18/3/23.
 */
public class PaintView extends View{
    public PaintView(Context context) {
        super(context);
    }

    public PaintView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = new RectF(10,10,100,100);
        Paint paint = new Paint();//画笔
        //去掉锯齿
        paint.setAntiAlias(true);

        //设置空心 stroke
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);
        paint.setColor(Color.RED);
        canvas.drawOval(rectF,paint);

    }
}
