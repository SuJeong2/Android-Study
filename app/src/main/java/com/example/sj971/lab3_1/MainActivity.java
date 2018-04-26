package com.example.sj971.lab3_1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //Initialize
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Reference
        button=(Button)findViewById(R.id.button1);

        //Register the ContextMenu on button
        registerForContextMenu(button);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);

        //set Menu Title
        menu.setHeaderTitle("Button Menu");

        //Add the menu on context menu
        menu.add(0,1,0,"Red");
        menu.add(0,2,0,"Green");
        menu.add(0,3,0,"Blue");
    }

    public boolean onContextItemSelected(MenuItem item){

        //To get selected menu id
        int color=item.getItemId();

        //According user choice, change the button text color
        switch (color){
            case 1:
                button.setTextColor(Color.RED);
                break;

            case 2:
                button.setTextColor(Color.GREEN);
                break;

            case 3:
                button.setTextColor(Color.BLUE);
                break;

            default: break;
        }

        return super.onContextItemSelected(item);
    }
}
