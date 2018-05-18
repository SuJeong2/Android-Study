package com.example.sj971.lab5_1;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView imageView1;
    ImageView imageView2;
    EditText editText;
    Button button;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);

        //Whem Button was clicked
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //First thread for left image
                DogThread thread1 = new DogThread(0);
                thread1.start();

                //Second thread for right image
                DogThread thread2 = new DogThread(1);
                thread2.start();
            }
        });
    }

    class DogThread extends Thread {

        int dogIndex;
        int stateIndex;

        ArrayList<Integer> images = new ArrayList<>();

        public DogThread(int index) {
            dogIndex = index;

            images.add(R.drawable.dog_eating);
            images.add(R.drawable.dog_standing);
            images.add(R.drawable.dog_study);
        }

        public void run() {
            stateIndex = 0;

            for (int i = 0; i < 9; i++) {
                final String msg = "dog #" + dogIndex + " state: " + stateIndex;

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        editText.append(msg + "\n");

                        //left image view
                        if (dogIndex == 0)
                        {
                            imageView1.setImageResource(images.get(stateIndex));
                        }

                        //right image view
                        else if (dogIndex == 1)
                        {
                            imageView2.setImageResource(images.get(stateIndex));
                        }
                    }
                });

                try {
                    //Randomly set time to show image
                    int sleepTime = getRandomTime(500, 300);
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                stateIndex++;
                //If stateIndex over 3
                if (stateIndex >= images.size()) {
                    stateIndex = 0;
                }
            }
        }
    }

    private int getRandomTime(int min, int max) {
        return min + (int) (Math.random() * (max - min));
    }
}