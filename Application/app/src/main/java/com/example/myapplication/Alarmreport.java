package com.example.myapplication;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Alarmreport extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(
                getApplicationContext(), MainActivity.class
        );
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarmreport);

        Button btnCancelAlarm = (Button) findViewById(R.id.btn_cancel);
        Button before = (Button) findViewById(R.id.button21);
        Button After = (Button) findViewById(R.id.button22);


        // 알람 초기화
        btnCancelAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (((Simplesetting5) Simplesetting5.sContext).alarmManager != null && ((Simplesetting5) Simplesetting5.sContext).mPendingIntent1 != null && ((RingtonePlayingService) RingtonePlayingService.ringContext).mNotificationManager != null) {
                        ((Simplesetting5) Simplesetting5.sContext).alarmManager.cancel(((Simplesetting5) Simplesetting5.sContext).mPendingIntent1);
                        ((RingtonePlayingService) RingtonePlayingService.ringContext).mNotificationManager.cancel(0);
                        ((RingtonePlayingService) RingtonePlayingService.ringContext).mNotificationManager.cancel(1);

                        final Intent cintent = new Intent(Alarmreport.this, AlarmReceiver.class);
                        cintent.putExtra("state", "alarm off");
                        sendBroadcast(cintent);

                        Toast.makeText(getApplicationContext(), "알람 초기화", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "알람 초기화", Toast.LENGTH_LONG).show();
                }

            }
        });


        // 알림 기록 불러오기
        TextView past_record = (TextView) findViewById(R.id.pastrecord);

        SharedPreferences sp = getSharedPreferences("record", MODE_PRIVATE);
        String text = sp.getString("add_log", "");
        past_record.setText(text);

        Log.d("기록 불러오기", "성공");

        After.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(), MainActivity.class
                );
                startActivity(intent);
                finish();
            }
        });

        before.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(), MainActivity.class
                );
                startActivity(intent);
                finish();
            }
        });


    }
}