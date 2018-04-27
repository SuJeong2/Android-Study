package com.example.sj971.lab3_3_r;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //Initialize
    public Button button1;
    public Button button2;

    Fragment1 fragment1;
    Fragment2 fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        setListener();
    }


    //To reference the button and fragment
    public void init(){
        button1=(Button)findViewById(R.id.TAB1);
        button2=(Button)findViewById(R.id.TAB2);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
    }

    //Listener functions
    private void setListener() {

        //When TAB!(Button1) was clicked, fragment1 is appear
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_for_fragment,fragment1).commit();

            }
        });

        //When TAB2(Button2) was clicked, fragment2 is appear
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_for_fragment,fragment2).commit();
            }
        });
    }
}
