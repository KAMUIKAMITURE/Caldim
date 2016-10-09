package com.lifeistech.android.quiz;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void next(View v){
        Intent intent = new Intent(Main2Activity.this, MainActivity.class);
        startActivity(intent);
    }
    public void record (View v){
        Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
        startActivity(intent);

    }
}
