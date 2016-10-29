package com.lifeistech.android.quiz;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import static com.lifeistech.android.quiz.R.drawable.hirameki;

public class Main4Activity extends AppCompatActivity {
    int Level;
    int check;
    ImageView imageView;
    private int data;
    private Integer data1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        imageView = (ImageView) findViewById(R.id.boss);
        SharedPreferences data = getSharedPreferences("DataSave", Context.MODE_PRIVATE);
        Level = data.getInt("LevelSave", 0);
        check = data.getInt("imagecount", 0);
        if (check == 1) {
            imageView.setImageResource(R.drawable.hirameki);
        }

    }


    public void charenge(View v) {

        if (Level < 100) {
            Toast toast = Toast.makeText(Main4Activity.this, "まだレベルが足りないよ！もっと頑張ろう！", Toast.LENGTH_LONG);
            toast.show();
        } else if (Level < 500) {
            if (check == 1) {
                Toast.makeText(Main4Activity.this, "まだレベルが足りないよ！もっと頑張ろう！", Toast.LENGTH_LONG).show();
            } else {
                Toast toast = Toast.makeText(Main4Activity.this, "やった！ボスを倒したぞ。次のボスを倒そう！", Toast.LENGTH_LONG);
                toast.show();
                imageView.setImageResource(hirameki);
                check = 1;

            }

        } else if (Level < 1000) {
            Toast toast = Toast.makeText(Main4Activity.this, "まだレベルが足りないよ！もっと頑張ろう！", Toast.LENGTH_LONG);
            toast.show();

        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (check == 1) {
            SharedPreferences data = getSharedPreferences("DataSave", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = data.edit();
            editor.putInt("bossimage", hirameki);
            editor.putInt("imagecount", check);
            editor.apply();
        }
    }
}
