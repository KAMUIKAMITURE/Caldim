package com.lifeistech.android.quiz;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class MainActivity extends Activity implements Runnable, SensorEventListener {

    private TextView answer1;
    private TextView answer2;
    private TextView answer3;
    private TextView answer4;
    private TextView count1;
    private TextView count2;
    private TextView sign;
    Random r = new Random();
    Random ra = new Random();
    Random ran = new Random();
    Random rando = new Random();
    SensorManager sm;
    float gx, gy, gz;
    Handler h;
    int number;
    int number2;
    int number3;
    int number4;
    int number5;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answer1 = (TextView) findViewById(R.id.anser1);
        answer2 = (TextView) findViewById(R.id.answer2);
        answer3 = (TextView) findViewById(R.id.answer3);
        answer4 = (TextView) findViewById(R.id.answer4);
        count1 = (TextView) findViewById(R.id.count1);
        count2 = (TextView) findViewById(R.id.count2);
        sign = (TextView) findViewById(R.id.sign);
        h = new Handler();
        h.postDelayed((Runnable) this, 500);
        SharedPreferences data = getSharedPreferences("DataSave", Context.MODE_PRIVATE);





        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> sensors =
                sm.getSensorList(Sensor.TYPE_ACCELEROMETER);
        if (0 < sensors.size()) {
            sm.registerListener(this, sensors.get(0),
                    SensorManager.SENSOR_DELAY_NORMAL);

//        makeQuestions();
//        startQuestions();
        }
        make();
    }



    private void make(){
        int ra = r.nextInt(9);
        int ran = r.nextInt(9);
        int rand = r.nextInt(3);
        int answer = rando.nextInt(4);

            number = ra;
            count1.setText(String.valueOf(number));

            number2 = ran;
            count2.setText(String.valueOf(number2));



        if (rand == 0) {
            sign.setText("+");
            plus();
        } else if (rand == 1) {
            sign.setText("-");
            minus();
        } else if (rand == 2) {
            sign.setText("*");
            kakeru();
        }
        if (answer == 0){
            answer1.setText(String.valueOf(number3));
            answer2.setText(String.valueOf(number3-1));
            answer3.setText(String.valueOf(number3+1));
            answer4.setText(String.valueOf(number3*2));

        } else if (answer == 1){
            answer1.setText(String.valueOf(number3+1));
            answer2.setText(String.valueOf(number3));
            answer3.setText(String.valueOf(number3*2));
            answer4.setText(String.valueOf(number3-1));
        } else if (answer == 2) {
            answer1.setText(String.valueOf(number3-1));
            answer2.setText(String.valueOf(number3*2));
            answer3.setText(String.valueOf(number3));
            answer4.setText(String.valueOf(number3+1));
        }else {
            answer1.setText(String.valueOf(number3*2));
            answer2.setText(String.valueOf(number3+1));
            answer3.setText(String.valueOf(number3-1));
            answer4.setText(String.valueOf(number3));
        }

//        doingAnswer();

    }
    private void plus() {
        number3 = number + number2;

    }



    private void minus() {
        number3 = number - number2;


    }

    private void kakeru() {
        number3 = number * number2;

    }









//    private void doingAnswer(){
//        int answer = rando.nextInt(4);
//        boolean flag = true;
//
//            try {
//                Thread.sleep(100);
//            }catch (InterruptedException e){
//                Log.e("error", e.toString());
//            }
//            if (answer == 0 && gy < -3) {
//
//            } else if (answer == 1 && gx > 5) {
//
//
//
//            } else if (answer == 2 && gx < -5) {
//
//
//
//            } else if (answer == 3 && gy > 5) {
//


//            } else {
//
//            }
//        }

    private void check (){
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy/MM/dd HH:mm:ss");
        Date d = null;
        try {
            d = sdf.parse("2016/10/09 13:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long timeStamp =  d.getTime() / 1000;

        int answer = rando.nextInt(4);

        if (answer == 0 && gy < -3) {
            number4++;
            SharedPreferences data = getSharedPreferences("DataSave", Context.MODE_PRIVATE);
            int Level = data.getInt("LevelSave",100);
            int all = number4 + Level;
            Log.d("kamui2",String.valueOf(data));
            SharedPreferences.Editor editor = data.edit();
            editor.putInt("LevelSave", all);
            editor.putInt("Timer", (int) timeStamp);
            editor.apply();

            make();


        }  else if (answer == 1 && gx > 5) {
            number4++;
            SharedPreferences data = getSharedPreferences("DataSave", Context.MODE_PRIVATE);
            int Level = data.getInt("LevelSave",100);
            int all = number4 + Level;
            Log.d("kamui2",String.valueOf(data));
            SharedPreferences.Editor editor = data.edit();
            editor.putInt("LevelSave", all);
            editor.apply();
        make();

        }  else if (answer == 2 && gx < -5) {
            number4++;
            SharedPreferences data = getSharedPreferences("DataSave", Context.MODE_PRIVATE);
            int Level = data.getInt("LevelSave",100);
            int all = number4 + Level;
            Log.d("kamui2",String.valueOf(data));
            SharedPreferences.Editor editor = data.edit();
            editor.putInt("LevelSave", all);
            editor.apply();
        make();
        }  else if (answer == 3 && gy > 5) {
            number4++;
            SharedPreferences data = getSharedPreferences("DataSave", Context.MODE_PRIVATE);
            int Level = data.getInt("LevelSave",100);
            int all = number4 + Level;
            Log.d("kamui2",String.valueOf(data));
            SharedPreferences.Editor editor = data.edit();
            editor.putInt("LevelSave", all);
            editor.apply();
       make();

        } else {
        }

    }

    





    @Override
    public void run() {



        }



    protected void onResume() {
        super.onResume();
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> sensors =
                sm.getSensorList(Sensor.TYPE_ACCELEROMETER);
        if (0 < sensors.size()) {
            sm.registerListener(this, sensors.get(0),
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        sm.unregisterListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        h.removeCallbacks(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        gx = event.values[0];
        gy = event.values[1];
        gz = event.values[2];
        Log.d("acc", "X-axis : " + gx + "\n" +
                "Y-axis : " + gy + "\n" +
                "Z-axis : " + gz + "\n");
        check();


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}

