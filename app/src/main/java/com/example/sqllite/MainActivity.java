package com.example.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Dbhelper dbhelper=new Dbhelper(this);

        //Saving to database
//        SQLiteDatabase db=dbhelper.getWritableDatabase();
//
//        ContentValues values=new ContentValues();
//        values.put("id","1");
//        values.put("name","Adebayo");
//        values.put("mark","90");
//
//        long row= db.insert("student",null,values);
//        System.out.println("Row number is "+ row);

        //Retrieving values from DB
        SQLiteDatabase db =dbhelper.getReadableDatabase();
        String projection[] ={"id","name","mark"};
        Cursor c= db.query("student",projection,
                null,null,null,
                null,null);

        c.moveToPosition(0);
        //System.out.println("Name is "+c.getString(1));

        TextView tv= findViewById(R.id.tv);
        tv.setText(c.getString(1));

    }
}