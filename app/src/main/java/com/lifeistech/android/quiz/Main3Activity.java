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
    int nowLevel;




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
            nowLevel = 2;
        } else if (Level < 500) {
            nextLevel = 500;
            nowLevel = 3;
        } else if (Level < 1000) {
            nextLevel = 1000;
            nowLevel = 4;
        } else {
            nextLevel = 0;
            nowLevel = 1;
        }


          String[] texts = {
                  "今まで正解した問題", String.valueOf(Level), "次のレベルアップまでに必要な正答数",
                  String.valueOf(nextLevel), "現在のレベル", String.valueOf(nowLevel)

        };

        ListView listView = new ListView(this);
        setContentView(listView);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, texts);
        listView.setAdapter(arrayAdapter);
    }


}
