package com.lifeistech.factory.caldim;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Main2Activity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    }

    public void next(View v) {
        Intent intent = new Intent(Main2Activity.this, MainActivity.class);
        startActivity(intent);
    }

    public void record(View v) {
        Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
        startActivity(intent);

    }

    public void boss(View v) {
        Intent intent = new Intent(Main2Activity.this, Main4Activity.class);
        startActivity(intent);
    }
}
