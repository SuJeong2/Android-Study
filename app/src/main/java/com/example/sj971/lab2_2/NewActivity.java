package com.example.sj971.lab2_2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class NewActivity extends AppCompatActivity {

    TextView textView;
    Button goBtn;
    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        //Reference the object
        textView=(TextView)findViewById(R.id.textField);
        goBtn=(Button)findViewById(R.id.goButton);
        backBtn=(Button)findViewById((R.id.backButton));

        final Intent passedIntent=getIntent(); //Get sent intent
        final String passedUrl=passedIntent.getStringExtra("url"); //get url which user input
        textView.setText(passedUrl); //write the url from user on text field

        //When GO button was clicked
        goBtn.setOnClickListener((view)->{
            //If there are text on
            if(!(passedUrl.equals(""))){
                //make intent which contains url
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+passedUrl));
                startActivity(intent);
            }

            //If there are no text on
            else{
                //float message
                Toast.makeText(getApplicationContext(),"주소를 다시 입력해주세요", Toast.LENGTH_LONG).show();
            }
        });

        //When BACK button was clicked
        backBtn.setOnClickListener((view)->{
            //float message
            Toast.makeText(getApplication(), "돌아가기버튼을 눌렀습니다", Toast.LENGTH_LONG).show();

            // return to 1stscreen and float Toast message
            finish();
        });
    }
}
