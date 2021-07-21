package com.example.sj971.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //declare variables
    public EditText edit_name;
    public Button printButton;
    public Button clearButton;
    public TextView print_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //To reference View objects
        init();
    }

    public void init()
    {
        //reference View objects
        edit_name=(EditText)findViewById(R.id.getName);
        printButton=(Button)findViewById(R.id.print);
        clearButton=(Button)findViewById(R.id.clear);
        print_name=(TextView)findViewById(R.id.printName);
    }

    public void clearButtonClicked(View view) {
        //initialize the EditText
        print_name.setText("");
    }

    public void printButtonClicked(View view) {
        String text= "";

        //Get the name value from EditText
        text=edit_name.getText().toString();

        //Print the name vlaue on TextView on Relative Layout
        print_name.setText(text);
    }
}
