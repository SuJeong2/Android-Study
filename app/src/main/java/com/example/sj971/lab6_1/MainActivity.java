package com.example.sj971.lab6_1;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button readButton, writeButton, clearButton, finishButton;

    File sdCard = Environment.getExternalStorageDirectory();
    File directory = new File(sdCard.getAbsolutePath()+"/myFile");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkPermission();

        editText=(EditText)findViewById(R.id.txtData);

        writeButton=(Button)findViewById(R.id.writeButton);
        readButton=(Button)findViewById(R.id.readButton);
        clearButton=(Button)findViewById(R.id.clearButton);
        finishButton=(Button)findViewById(R.id.finishButton);

        writeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    String value = editText.getText().toString();

                    //Make the file path
                    directory.mkdirs();
                    File file = new File (directory, "textfile.txt");

                    //Make file output Stream, writer for writing the string on SD file
                    FileOutputStream fOut = new FileOutputStream(file);
                    OutputStreamWriter osw = new OutputStreamWriter(fOut);

                    //write to the file
                    osw.write(value);

                    //close the output Stream
                    osw.close();
                    fOut.close();

                    Toast.makeText(getApplicationContext(), "Done writing SD file", Toast.LENGTH_SHORT).show();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        readButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                try {
                    //Make the file path
                    directory.mkdirs();
                    File file = new File (directory, "textfile.txt");

                    //Make file input Stream, reader for reading the string on SD file
                    FileInputStream fIn = new FileInputStream(file);
                    BufferedReader br = new BufferedReader(new FileReader(file));

                    String read_value="";
                    String str = null;

                    //read the string until file end
                    while ((str=br.readLine())!=null){
                        read_value+=str;
                    }

                    //Write on the editText area
                    editText.setText(read_value);

                    //close
                    br.close();
                    fIn.close();

                    Toast.makeText(getApplicationContext(), "Done reading SD file", Toast.LENGTH_SHORT).show();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            };
        });

        clearButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                editText.setText("");
                editText.setHint("Enter some lines of data");
            }
        });

        finishButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    //To put the permission on SD file, External storage
    void  checkPermission() {
        int permissioninfo = ContextCompat.checkSelfPermission
                (this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permissioninfo == PackageManager.PERMISSION_GRANTED) {

        }

        else{
            if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)){
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
            }

            else{
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},100);
            }
        }
    }

    public void onRequestPermissionResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==100){
            if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "SD 카드 쓰기 권한 승인", Toast.LENGTH_SHORT).show();
            }

            else{
                Toast.makeText(this, "SD 카드 쓰기 권한 거부", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
