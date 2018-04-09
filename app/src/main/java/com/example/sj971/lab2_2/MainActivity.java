package com.example.sj971.lab2_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText url;
    Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Reference the object
        url=(EditText)findViewById(R.id.urlText);
        nextBtn=(Button)findViewById(R.id.nextButton);

        //Event-when next button was clicked
        nextBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Get the url from text field
                String myURL=url.getText().toString();

                //Make intent
                Intent intent = new Intent(getApplicationContext(), NewActivity.class);
                intent.putExtra("url", myURL); //send url which user input (url is mark for separation
                startActivity(intent); //call
            }
        });
    }
}
