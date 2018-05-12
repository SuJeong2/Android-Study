package com.example.sj971.lab4_2;

import android.app.Fragment;
import android.graphics.drawable.Animatable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button1;
    Button button2;

    LinearLayout frame1;
    LinearLayout frame2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);

        frame1 = (LinearLayout) findViewById(R.id.frame1);
        frame2 = (LinearLayout) findViewById(R.id.frame2);

        //If button1 on the first linear layout
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Make an animation
                //left_slide.xml => from left, frame2 is slide and visible
                Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.left_slide);

                //start the animation
                frame2.startAnimation(anim);

                //Show frame2
                frame2.setVisibility(View.VISIBLE);
            }
        });

        //If button2 on the second linear layout
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Make an animation
                //right_slide.xml => from right, frame2 is slide and invisible
                Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_slide);

                //start the animation
                frame2.startAnimation(anim);

                //Disappear frame2
                frame2.setVisibility(View.GONE);
            }
        });
    }
}
