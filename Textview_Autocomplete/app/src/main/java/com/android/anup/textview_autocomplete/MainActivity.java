package com.android.anup.textview_autocomplete;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Dbhelper db= new Dbhelper(MainActivity.this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AutoCompleteTextView txtview= (AutoCompleteTextView)findViewById(R.id.auct1);
        db.deleteAllItems();
        db.insertData("Hp Printer");
        db.insertData("Lenovo Desktop");
        db.insertData("Samsung galaxy Note 7");
        db.insertData("VR Gear");
        db.insertData("iPhone 6");
        db.insertData("Panasonic Viera Smart TV");
        String[] strings=db.SelectAllData();
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(MainActivity.this,R.layout.text_view, strings);

        txtview.setAdapter(arrayAdapter);
        txtview.setThreshold(2);
    }
}

