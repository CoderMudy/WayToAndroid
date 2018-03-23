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
public class CanvasView extends View{
    public CanvasView(Context context) {
        super(context);
    }

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = new RectF(0,0,100,100);
        Paint paint = new Paint();

        //画线
//        canvas.drawLine(0,10,100,100,paint);

        canvas.drawText("hahaha",12,12,paint);

    }
}
