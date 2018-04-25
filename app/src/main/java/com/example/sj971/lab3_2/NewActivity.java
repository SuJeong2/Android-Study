package com.example.sj971.lab3_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {

    //Make objects
    TextView nameText;
    TextView sexText;
    TextView checkText;
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        //Reference
        nameText=(TextView)findViewById(R.id.nameText);
        sexText=(TextView)findViewById(R.id.sexText);
        checkText=(TextView)findViewById(R.id.editText);
        backButton=(Button)findViewById(R.id.backButton);

        //To get information on Intent, Bundle
        Intent intent2 = getIntent();

        Bundle bundle= intent2.getExtras();

        //Using key value, get information
        String name=bundle.getString("name");
        String sex=bundle.getString("sex");
        String check=bundle.getString("check");

        //Set the text according user's information
        nameText.setText(name);
        sexText.setText(sex);
        checkText.setText(check);

        //If button was clicked, go back initial page
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
