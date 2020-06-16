package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AlarmCheck extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarmcheck);

        // 현재 날짜 출력
        SimpleDateFormat format = new SimpleDateFormat ( "yyyy년 MM월 dd일 HH시 mm분");
        Calendar dtime = Calendar.getInstance();
        String format_dtime = format.format(dtime.getTime());

        TextView date_now = (TextView)findViewById(R.id.current_date);
        date_now.setText(format_dtime);


        findViewById(R.id.button_stop).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(AlarmCheck.this,"생존 알람 확인 완료",Toast.LENGTH_SHORT).show();

                final Intent tintent = new Intent(AlarmCheck.this, AlarmReceiver.class);
                tintent.putExtra("state","alarm off");
                sendBroadcast(tintent);

                addLog();

                // 알람 확인하면 MainActivity로 이동
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);



            }
        });
    }

    // 알림 확인 성공 로그 추가
    public void addLog() {

        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar time1 = Calendar.getInstance();
        String format_time1 = format1.format(time1.getTime());


        SharedPreferences sharedPreferences1 = getSharedPreferences("record", MODE_PRIVATE);
        String past1 = sharedPreferences1.getString("add_log", "");
        past1 = format_time1 + "  - 알림 확인\n" + past1;

        SharedPreferences.Editor editor1 = sharedPreferences1.edit();
        editor1.putString("add_log", past1);
        editor1.commit();

        Log.d("addLog() 실행", "성공");

    }
}
