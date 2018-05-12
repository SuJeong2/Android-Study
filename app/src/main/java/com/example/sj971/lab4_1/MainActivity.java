package com.example.sj971.lab4_1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    float x,y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Make myDraw object
        MyDraw myDraw = new MyDraw(this);
        setContentView(myDraw);
    }
}
