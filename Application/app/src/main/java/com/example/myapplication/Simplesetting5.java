package com.example.myapplication;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.Button;

import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import java.util.ArrayList;
import java.util.Calendar;


public class Simplesetting5 extends AppCompatActivity {
    public static Context sContext;
    public AlarmManager alarmManager;
    public PendingIntent mPendingIntent1;
    ArrayAdapter<CharSequence> dayspin1;
    String choice_day = "";
    int int_day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ArrayAdapter<String> arrayAdapter;
        ArrayList<String> arraylist;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simplesetting5);
        sContext = this;


        arraylist = new ArrayList<>();
        arraylist.add("1일");
        arraylist.add("2일");
        arraylist.add("3일");
        arraylist.add("5일");
        arraylist.add("7일");
        arraylist.add("10일");
        arraylist.add("14일");

        arrayAdapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item, arraylist);
        final Spinner spin3 = (Spinner)findViewById(R.id.spinner3);
        spin3.setAdapter(arrayAdapter);
        spin3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                choice_day = parent.getItemAtPosition(position).toString();
                //데이터 저장
                SharedPreferences day_preferences = getSharedPreferences("Day_Output", MODE_PRIVATE);
                SharedPreferences.Editor editor1 = day_preferences.edit();
                editor1.putString("day_1", choice_day);
                editor1.commit();
                int_day = Integer.parseInt(choice_day.replace("일",""));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //타임피커
        final TimePicker timePicker = findViewById(R.id.time_picker);
        // 알람 매니저 설정
        alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        // calendar 객체 생성
        final Calendar calendar = Calendar.getInstance();
        // 알람Receiver intent 생성
        final Intent mintent = new Intent(Simplesetting5.this, AlarmReceiver.class);



        Button before = (Button) findViewById(R.id.button15);
        Button After = (Button) findViewById(R.id.button16);

        After.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                // 알람 시간 설정 //

                // calendar에 알람 시간 설정
                calendar.set(Calendar.HOUR_OF_DAY, timePicker.getHour());
                calendar.set(Calendar.MINUTE, timePicker.getMinute());
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);


                // 알람Receiver에 string 값 넘겨주기
                mintent.putExtra("state","alarm on");
                mPendingIntent1 = PendingIntent.getBroadcast(Simplesetting5.this, 0, mintent, PendingIntent.FLAG_UPDATE_CURRENT);

                // 알람 설정(반복)
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 1000*30*int_day, mPendingIntent1);
                Log.d("알람 설정", "알람 설정 완료");
                Toast.makeText(Simplesetting5.this,timePicker.getHour()+"시 "+timePicker.getMinute()+"분 "+ + int_day+"일 간격으로 알림이 설정되었습니다." ,Toast.LENGTH_SHORT).show();




                // 푸시 알림 설정 //

                // 알림창에 뜨는 큰 이미지 설정
                Bitmap mLargeIcon =
                        BitmapFactory.decodeResource(getResources(), R.drawable.warning);

                final PendingIntent mPendingIntent2 = PendingIntent.getActivity(Simplesetting5.this, 0,
                        new Intent(getApplicationContext(), MainActivity.class),
                        PendingIntent.FLAG_UPDATE_CURRENT);

                //오전, 오후
                String ampm;
                int hour;

                if (timePicker.getHour() == 12){
                    hour = timePicker.getHour();
                    ampm = "오후 ";
                }
                else if (timePicker.getHour() == 24){
                    hour = timePicker.getHour() - 12;
                    ampm = "오전 ";
                }
                else if (timePicker.getHour() > 12){
                    hour = timePicker.getHour() - 12;
                    ampm = "오후 ";

                }
                else {
                    hour = timePicker.getHour();
                    ampm = "오전 ";
                }


                // 푸시알림 객체 생성 및 설정
                NotificationCompat.Builder mBuilder =
                        new NotificationCompat.Builder(Simplesetting5.this)
                                .setSmallIcon(R.drawable.warning) // 상단바에 노출되는 작은 이미지
                                .setContentTitle("생존 확인 어플 실행 중")
                                .setContentText(choice_day+"일 간격으로 "+ ampm + hour+"시 "+timePicker.getMinute()+"분에 알림이 울립니다.")
                                .setLargeIcon(mLargeIcon) // 상단바 큰 이미지
                                .setAutoCancel(false) // 알림이 설정되었을 경우, 항상 상단바에 노출
                                .setContentIntent(mPendingIntent2); // notification 알림을 터치하면 MainActivity로 전환

                NotificationManager mNotificationManager =
                        (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                mNotificationManager.notify(0, mBuilder.build());






                //다음페이지
                Intent intent1 = new Intent(
                        getApplicationContext(), MainActivity.class
                );
                startActivity(intent1);

            }
        });

        before.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(), Simplesetting4.class
                );
                startActivity(intent);
            }
        });
    }
}