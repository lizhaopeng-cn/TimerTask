package com.example.lzp.timertask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private TextView txtView;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        txtView = (TextView)findViewById(R.id.text);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                final String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
                Log.e("time",date);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        txtView.setText(date);
                    }
                });
            }
        };
        Timer timer = new Timer();
        Log.e("time","start time：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis())));
        timer.schedule(task,5000,3000);
    }
}
