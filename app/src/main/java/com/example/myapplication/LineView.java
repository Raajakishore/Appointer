package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class LineView extends View {
    PointF pointA ;
    PointF pointB ;
    Paint paint = new Paint();
    public LineView(Context context) {
        super(context);}
        public void setpointA(PointF point){
            pointA = point;
        }
    public void setpointB(PointF point){
        pointB = point;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(getResources().getColor(R.color.colorAcent));
        paint.setStrokeWidth(2);
        canvas.drawLine(pointA.x,pointA.y,pointB.x,pointB.y,paint);
        super.onDraw(canvas);
    }

    public LineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public LineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void draw(){
        invalidate();
        requestLayout();
    }
}

