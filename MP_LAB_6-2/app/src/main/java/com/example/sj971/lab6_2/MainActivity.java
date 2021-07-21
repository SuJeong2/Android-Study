package com.example.sj971.lab6_2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;

public class MainActivity extends AppCompatActivity {

    Button getButton, storeButton, resetButton;
    EditText numberText, nameText;

    String name, number;
    String name2, number2;

    SharedPreferences sh_Pref;
    SharedPreferences.Editor toEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getButton=(Button)findViewById(R.id.getButton);
        storeButton=(Button)findViewById(R.id.storeButton);
        resetButton=(Button)findViewById(R.id.resetButton);

        numberText=(EditText)findViewById(R.id.student_number);
        nameText=(EditText)findViewById(R.id.student_name);

        getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Get the information on sh_Pref
                sh_Pref=getSharedPreferences("Info", MODE_PRIVATE);
                if(sh_Pref!=null && sh_Pref.contains("number") && sh_Pref.contains("name")){
                    number2=sh_Pref.getString("number","nonnumber");
                    name2=sh_Pref.getString("name","nonname");

                    //Set the values on text area
                    numberText.setText(number2);
                    nameText.setText(name2);
                }
            }
        });

        storeButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                //Get the value on editText area
                number = numberText.getText().toString();
                name = nameText.getText().toString();

                //call the functions to store the information
                sharedPrefernces();
            }
        });

        //Reset the editText area
        resetButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                numberText.setText("");
                nameText.setText("");

                numberText.setHint("...");
                nameText.setHint("...");
            }
        });
    }

    //Store information on shared preference
    public void sharedPrefernces(){
        sh_Pref=getSharedPreferences("Info", MODE_PRIVATE);
        toEdit=sh_Pref.edit();
        toEdit.putString("number", number);
        toEdit.putString("name",name);
        toEdit.commit();
    }
}
