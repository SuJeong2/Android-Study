package com.example.sj971.lab5_2;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText;
    TextView textView;
    TextView resultView;

    int num;
    int result = 1;
    String msg = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);
        resultView = (TextView) findViewById(R.id.resultView);

        //If button was clicked, then read the number which user type, and start work
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = Integer.parseInt(editText.getText().toString());
                new CalculateTask().execute(num);
            }
        });

    }

    private class CalculateTask extends AsyncTask<Integer, Integer, Integer> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        /*
        Calculate the value and write on the text view
         */
        @Override
        protected Integer doInBackground(Integer... params) {

            int result = 1;
            int value = params[0];

            for (int i = value; i >= 1; i--) {
                try {
                    result *= i;
                    publishProgress(i);
                    Thread.sleep(500);
                } catch (InterruptedException e) {

                }
            }

            return result;
        }

        //write on the text view -> With previous value
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate();

            msg = msg + " " + Integer.toString(values[0].intValue());
            textView.setText(msg);
        }

        //write the result on the result view
        @Override
        protected void onPostExecute(Integer result_num) {
            super.onPostExecute(result_num);

            resultView.setText(""+result_num);
        }
    }

}
