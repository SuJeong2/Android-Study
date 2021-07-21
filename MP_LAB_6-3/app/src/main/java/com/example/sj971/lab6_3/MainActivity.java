package com.example.sj971.lab6_3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    MySQLiteHelper helper;

    Button addButton, deleteButton;
    EditText nameText, numberText;
    ListView listView;

    String name, number;
    String[] info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);

        addButton=(Button)findViewById(R.id.addButton);
        deleteButton=(Button)findViewById(R.id.deleteButton);

        nameText=(EditText)findViewById(R.id.name);
        numberText=(EditText)findViewById(R.id.number);

        helper = new MySQLiteHelper(MainActivity.this, "Student.db", null,1);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = nameText.getText().toString();
                number = numberText.getText().toString();

                //If user don't put name or number, It can't be add on list View
                if(name.equals("") || number.equals("")){
                    Toast.makeText(getApplicationContext(),"모든 항목을 입력해주세요", Toast.LENGTH_SHORT).show();
                }

                else{
                    //Insert
                    insert(name,number);

                    //Read DB and show in listview
                    invalidate();
                }
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name=nameText.getText().toString();

                //If user don't input the name, then it can't be delete
                if(name.equals("")){
                    Toast.makeText(getApplicationContext(),"이름을 입력해주세요", Toast.LENGTH_SHORT).show();
                }

                else {
                    //delete of name
                    delete(name);

                    //Read DB and show in listview
                    invalidate();
                }
            }
        });
    }

    public void insert(String name_value, String number_value){
        db=helper.getWritableDatabase();
        ContentValues values = new ContentValues();

        //Put the value on DB
        values.put("name", name_value);
        values.put("number", number_value);
        db.insert("Student",null,values);
        Log.i("db",name+"정상적으로 추가됨");
    }

    public void delete(String name){
        db=helper.getWritableDatabase();

        //Delete <name> on DB
        db.delete("Student","name=?", new String[]{name});
        Log.i("db",name+"정상적으로 삭제됨");
    }

    public void select(){
        db=helper.getReadableDatabase();

        //Make cursor
        Cursor c = db.query("Student", null,null,null,null,null,null );

        //Make array info size of DB rows
        info = new String[c.getCount()];
        int count=0;

        //Until DB end
        while(c.moveToNext()){
            info[count] = c.getString(c.getColumnIndex("name"))+" "+c.getString(c.getColumnIndex("number"));
            count++;
        }

        c.close();
    }

    private void invalidate(){
        //Read the DB and store information on array info
        select();

        //Show on list view
        ArrayAdapter <String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, info);
        listView.setAdapter(adapter);
    }

    private class MySQLiteHelper extends SQLiteOpenHelper{

        public MySQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            //for create sql
            String sql ="create table Student ("+"name text, "+"number text);";
            db.execSQL(sql);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            //for delete sql
            String sql = "drop table if exists Student";
            db.execSQL(sql);
            onCreate(db);
        }
    }
}
