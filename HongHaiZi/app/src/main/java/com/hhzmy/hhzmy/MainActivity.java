package com.hhzmy.hhzmy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ehhzmy.hhzmy.R;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    Timer timer=new Timer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SharedPreferences sp=getSharedPreferences("main", Context.MODE_PRIVATE);
        boolean flag=sp.getBoolean("sp", true);
        if(!flag){ TimerTask task=new TimerTask() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                Intent intent=new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
                finish();
            }
        };
            timer.schedule(task, 3000); }else {TimerTask task=new TimerTask() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                Intent intent=new Intent(MainActivity.this, Main3Activity.class);
                startActivity(intent);
                finish();
            }
        };
            timer.schedule(task, 3000);

        }


    }
}
