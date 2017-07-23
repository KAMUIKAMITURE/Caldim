package com.lifeistech.factory.caldim;

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
//    ListView listView;
//
//    static List<String> items = new ArrayList<String>();
//    static ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

// listView = (ListView)findViewById(R.id.listView);


//        adapter =
//                new ArrayAdapter<String>(
//                        this,
//                        R.layout.listView,
//                        R.id.listViewLine,
//                        items
//                        );
//
//        listView.setAdapter(adapter);


        SharedPreferences data = getSharedPreferences("DataSave", Context.MODE_PRIVATE);

        Log.d("kamui", String.valueOf(data.getInt("LevelSave", 0)));
        int Level = data.getInt("LevelSave", 0);

        if (Level < 50) {
            nextLevel = 50;
            nowLevel = 1;
        } else if (Level < 300) {
            nextLevel = 300;
            nowLevel = 2;
        } else if (Level < 500) {
            nextLevel = 500;
            nowLevel = 3;
        } else if (Level < 800) {

            nextLevel = 800;
            nowLevel = 4;
        } else if (Level < 1100) {
            nextLevel = 1100;
            nowLevel = 5;

        }


        String[] texts = {
                "今まで正解した問題", String.valueOf(Level), "次のレベルアップまでに必要な正答数",
                String.valueOf(nextLevel), "現在のレベル", String.valueOf(nowLevel)

        };

        ListView listView = new ListView(this);
        setContentView(listView);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, texts);
        listView.setAdapter(arrayAdapter);
    }


}
