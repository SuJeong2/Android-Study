package com.example.sj971.lab4_1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.text.AttributedCharacterIterator;

/**
 * Created by sj971 on 2018-05-10.
 */

public class MyDraw extends View {

    float x,y;
    private Paint paint = new Paint();
    private Path path = new Path();

    public MyDraw(Context context) {
        super(context);
    }

    public MyDraw (Context context, AttributeSet a){
        super(context,a);
    }

    public boolean onTouchEvent(MotionEvent event) {

        //Get point location of x, y
        x=event.getX();
        y=event.getY();

        //According action event, handle the operation
        switch (event.getAction()){

            //If user down the cursor, move the cursor
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x,y);
                return true;

            //If user moves cursor, drawing the line
            case MotionEvent.ACTION_MOVE:
                    path.lineTo(x,y);
                    break;

            //If user stop drawing
            case MotionEvent.ACTION_UP:
                break;

            default:
                return false;
        }

        invalidate();
        return true;
    }

    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        paint.setAntiAlias(true);
        paint.setStrokeWidth(12);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);

        canvas.drawPath(path,paint);
    }
}
