package com.example.sj971.lab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    //declare image value as object
    ImageView imageView;
    ImageView imageView2;

    //indicate which image is loaded
    int imageIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get image value
        imageView = (ImageView) findViewById(R.id.image);
        imageView2 = (ImageView) findViewById(R.id.image2);

    }

    //when button is clicked, run changeImage function
    public void onButtonClicked(View view) {
        changeImage();
    }

    private void changeImage() {

        //when image 1 is loaded
        if (imageIndex == 0) {
            imageView.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.INVISIBLE);

            imageIndex = 1;
        }

        //when image 2 is loaded
        else if (imageIndex != 0) {
            imageView.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.VISIBLE);

            imageIndex = 0;

        }
    }
}
