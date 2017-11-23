package com.example.evergistelova.listmenu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;


public class MyDrawView extends View {
    Paint paint = new Paint();
    Point point = null;

    public MyDrawView(Context context, AttributeSet attrs) {
        super(context,attrs);
        paint.setColor(Color.BLACK);
    }

    @Override
    protected void onDraw (Canvas canvas) {
        super.onDraw(canvas);
        if (point != null)
            canvas.drawCircle(point.x, point.y, 40, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        point = new Point();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                point.x = (int)event.getX();
                point.y = (int)event.getY();
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                point.x = (int)event.getX();
                point.y = (int)event.getY();
                invalidate();
                break;
            case MotionEvent.ACTION_UP :
                point = null;
                invalidate();
                break;
            default :
                break;
        }
        return true;
    }
}
