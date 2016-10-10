package com.lifeistech.android.quiz;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Main3Activity extends AppCompatActivity {
    int nextLevel;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        SharedPreferences data = getSharedPreferences("DataSave", Context.MODE_PRIVATE);
        Log.d("kamui",String.valueOf(data.getInt("LevelSave",100)));
        int Level = data.getInt("LevelSave",100);
        int level = data.getInt("Timer",100);
        if (Level < 100) {
            nextLevel = 100;
        } else if (Level < 500) {
            nextLevel = 500;
        } else if (Level < 1000) {
            nextLevel = 1000;
        } else {
            nextLevel = 0;
        }


          String[] texts = {
                  "今まで正解した問題", String.valueOf(Level), "次のレベルアップまでに必要な正答数",
                  String.valueOf(nextLevel)

        };

        ListView listView = new ListView(this);
        setContentView(listView);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, texts);
        listView.setAdapter(arrayAdapter);
    }


}
