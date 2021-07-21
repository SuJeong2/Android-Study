package com.example.sj971.lab2_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by sj971 on 2018-04-09.
 */

public class NewActivity extends AppCompatActivity{

    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        //get intent
        Intent passedIntent = getIntent();

        //if input is not empty
        if(passedIntent!=null)
        {
            //Get the name and age from intent
            String loginName=passedIntent.getStringExtra("loginName");
            String loginAge=passedIntent.getStringExtra("loginAge");

            //float the message
            Toast.makeText(this, "Student Info: "+loginName+", "+loginAge, Toast.LENGTH_SHORT).show();

        }

        //when button was clicked, go back
        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish(); //finish and go back to first page
            }
        });
    }
}