package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AlarmReceiver extends BroadcastReceiver {
    Context context;

    @Override
    public void onReceive(Context context, Intent intent){
        this.context = context;
        Log.d("알람 설정", "receiver 전달");

        // intent로부터 전달받은 string 값
        String get_value = intent.getExtras().getString("state");

        // RingtonePlayingService 서비스 intent 생성
        Intent service_intent = new Intent(context, RingtonePlayingService.class);
        Log.d("알람 설정", "ringtone 전달");

        // RingtonePlayingService로 extra string값 보내기
        service_intent.putExtra("state", get_value);

        // RingTone 서비스 시작
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O){
            this.context.startForegroundService(service_intent);
        }else{
            this.context.startService(service_intent);
        }
        Log.d("알람 설정", "ringtone 시작");
    }

}
