package com.example.sj971.lab2_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText age;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Reference objects
        button =(Button)findViewById(R.id.button1);
        name=(EditText)findViewById(R.id.name);
        age=(EditText)findViewById(R.id.age);

        //If button was clicked
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Get name and age from edit field
                String Name=name.getText().toString();
                String Age=age.getText().toString();

                //To send the name and age, use intent
                Intent intent = new Intent(getApplicationContext(), NewActivity.class);
                intent.putExtra("loginName", Name);
                intent.putExtra("loginAge",Age);
                startActivity(intent);
            }
        });
    }
}