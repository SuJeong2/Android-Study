package com.example.sj971.lab3_2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Make objects
    Button button1;
    EditText getName;
    RadioGroup radioGroup;
    RadioButton manButton;
    RadioButton womanButton;
    CheckBox snsButton;
    CheckBox emailButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Reference
        button1=(Button)findViewById(R.id.button1);
        getName=(EditText)findViewById(R.id.editText);

        radioGroup=(RadioGroup)findViewById(R.id.group);
        snsButton=(CheckBox)findViewById(R.id.snsButton);
        emailButton=(CheckBox)findViewById(R.id.emailButton);

        manButton=(RadioButton) findViewById(R.id.manButton);
        womanButton=(RadioButton)findViewById(R.id.womanButton);

        //If button was clicked,store the information and deliver these thing to other activity
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Initialize String value
                //Get user name on editText
                String name = getName.getText().toString();
                String sex=null;
                String check = "";

                //To get user's sex, chekc RadioGoup and RadioButton
                int radioID=radioGroup.getCheckedRadioButtonId();

                //User can choice only 1 sex, so input the info on string
                if(manButton.getId()==radioID){
                    sex="남";
                }

                if(womanButton.getId()==radioID){
                    sex="여";
                }

                //To get user's choice, use CheckBox
                //User can choice one or two or more, so using CheckBox is proper
                //User can choice one or more, add string
                if(snsButton.isChecked()){
                    check+=" sns";
                }

                if(emailButton.isChecked()){
                    check+=" email";
                }

                //Make an intent
                Intent intent = new Intent(getApplicationContext(), NewActivity.class);

                //To deliver information, using Bundle
                //We have to deliver 3 kind of information, so use 3 bundles
                //Each Bundle have their own key value
                Bundle bundle1=new Bundle();
                bundle1.putString("name", name);
                intent.putExtras(bundle1);

                Bundle bundle2=new Bundle();
                bundle2.putString("sex", sex);
                intent.putExtras(bundle2);

                Bundle bundle3=new Bundle();
                bundle3.putString("check", check);
                intent.putExtras(bundle3);

                startActivity(intent);
            }
        });
    }
}
