package com.example.ios.simplecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Storie extends AppCompatActivity {

    ListView listStorie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storie);

        listStorie = findViewById(R.id.listStorie);
        Intent intent = getIntent();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                intent.getStringArrayListExtra("Storie") );

        listStorie.setAdapter(arrayAdapter);
    }
}
