package com.mudy.customview01;

import android.content.Context;
import android.graphics.*;
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
        //canvas.drawLine(0,10,100,100,paint);

        //文本
        paint.setColor(Color.RED);
        paint.setTextSize(30);//设置绘制文本时候的文字大小
        canvas.drawText("hahaha",100,100,paint);

        //画点
        paint.setStrokeWidth(5);
        canvas.drawPoint(150,150,paint);

        //画图片
        // 1 将项目中已有的图片转为bitmap  mipmap-hdpi/ic_launcher.png
        //Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        //2 完全自己创建一个bitmap
        Bitmap bitmap = Bitmap.createBitmap(100,100, Bitmap.Config.ALPHA_8);
        for(int i = 0;i<100;i++){
            for (int j = 0;i<100;j++){
                bitmap.setPixel(i,j,Color.RED);
            }
        }

        canvas.drawBitmap(bitmap,150,200,paint);
    }
}
