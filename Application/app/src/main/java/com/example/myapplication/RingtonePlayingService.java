package com.example.myapplication;

import android.Manifest;
import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class RingtonePlayingService extends Service {

    final int SEND_SMS_PERMISSION_REQUEST_CODE = 1;

    public NotificationManager mNotificationManager;
    public static final String NOTIFICATION_CHANNEL_ID_CHECK = "20002";

    public static int fail_count = 0;
    public static Context ringContext;

    MediaPlayer mediaPlayer;
    int startId;
    boolean isRunning;
    int cancel;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ringContext = this;
        Log.d("ringtone", "연결");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        //state 값 받기
        String getState = intent.getExtras().getString("state");


        assert getState != null;
        switch (getState) {
            case "alarm on":
                startId = 1;
                cancel = 1;
                break;
            case "alarm off":
                startId = 0;
                cancel = 0;
                break;
            default:
                startId = 0;
                cancel = 0;
                break;
        }


        // 알람음 재생 X , 알람음 시작 클릭
        if (!this.isRunning && startId == 1) {
            Toast.makeText(this, "알람이 울립니다", Toast.LENGTH_LONG).show();

            PendingIntent mPendingIntent = PendingIntent.getActivity(this, 0,
                    new Intent(getApplicationContext(), AlarmCheck.class),
                    PendingIntent.FLAG_UPDATE_CURRENT);

            mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            NotificationCompat.Builder mBuilder =
                    new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID_CHECK)
                            //.setSmallIcon(R.drawable.ic_warning) // 상단바에 노출되는 작은 이미지
                            .setContentTitle("알림이 울립니다")
                            .setContentText("확인해주세요")
                            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                            .setAutoCancel(true) // 알림창 클릭하면 사라짐
                            .setContentIntent(mPendingIntent); // 알림창 클릭하면 AlarmCheck로 이동

            //OREO API 26 이상에서는 채널 필요
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                mBuilder.setSmallIcon(R.drawable.ic_warning); //mipmap 사용시 Oreo 이상에서 시스템 UI 에러남
                CharSequence channelName  = "노티페케이션 채널";
                String description = "오레오 이상을 위한 것임";
                int importance = NotificationManager.IMPORTANCE_HIGH;

                NotificationChannel channel = new NotificationChannel(NOTIFICATION_CHANNEL_ID_CHECK, channelName , importance);
                channel.setDescription(description);

                // 노티피케이션 채널을 시스템에 등록
                assert mNotificationManager != null;
                mNotificationManager.createNotificationChannel(channel);

            }else mBuilder.setSmallIcon(R.mipmap.ic_launcher); // Oreo 이하에서 mipmap 사용하지 않으면 Couldn't create icon: StatusBarIcon 에러남

            mNotificationManager.notify(1, mBuilder.build());


            mediaPlayer = MediaPlayer.create(this, R.raw.i_like_peanuts); // 임의로 알림음 설정함. 추후 변경 가능
            mediaPlayer.start();

            this.isRunning = true;
            this.startId = 0;
            cancel = 1;


        }

        // 알람음 재생 O , 알람음 종료 버튼 클릭
        else if (this.isRunning && startId == 0) {

            mediaPlayer.stop();
            mediaPlayer.reset();
            mediaPlayer.release();

            this.isRunning = false;
            this.startId = 0;
            cancel = 0;
        }

        // 알람음 재생 X , 알람음 종료 버튼 클릭
        else if (!this.isRunning && startId == 0) {

            this.isRunning = false;
            this.startId = 0;
            cancel = 0;

        } else {

        }

        // 10초간 확인하지 않을 경우 알림 확인 실패
        Handler hand = new Handler();
        hand.postDelayed(new Runnable() {

            @Override
            public void run() {
                if (cancel == 1) {
                    cancel = 0;

                    final Intent cancel_intent = new Intent(RingtonePlayingService.this, AlarmReceiver.class);
                    cancel_intent.putExtra("state", "alarm off");
                    sendBroadcast(cancel_intent);

                    mNotificationManager.cancel(1);
                    failLog();

                }
            }

        }, 10 * 1000);

        return START_NOT_STICKY;


    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.d("onDestory() 실행", "서비스 파괴");

    }


    // 알림 확인 실패 로그 추가
    public void failLog() {

        SimpleDateFormat format2 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
        Calendar time2 = Calendar.getInstance();
        String format_time2 = format2.format(time2.getTime());


        SharedPreferences sharedPreferences2 = getSharedPreferences("record",MODE_PRIVATE);
        String past2 = sharedPreferences2.getString("add_log", "");
        past2 =  format_time2 + "  - 알림 실패\n" + past2 ;

        SharedPreferences.Editor editor2 = sharedPreferences2.edit();
        editor2.putString("add_log", past2);
        editor2.commit();

        fail_count++;
        Log.d("failLog() 실행", "성공");

        Toast.makeText(RingtonePlayingService.this,"알림 확인 실패 : " + fail_count+"회",Toast.LENGTH_SHORT).show();

        // 알림 확인 실패가 누적되면 sms 신고
        if(fail_count == 1){
            if(checkPermission(Manifest.permission.SEND_SMS)){
                snsService();
            } else {
                // 메시지 권한 없을 경우 다시 요청
                Toast.makeText(getApplicationContext(), "Permission Denied", Toast.LENGTH_LONG).show();
                ActivityCompat.requestPermissions((Activity) ringContext, new String[]{Manifest.permission.SEND_SMS}, SEND_SMS_PERMISSION_REQUEST_CODE);
            }

            fail_count = 0;

        }

    }

    public void snsService(){
        //주소, 이름, 보호자 전화번호 불러오기
        SharedPreferences add_preferences = getSharedPreferences("Address_Output", MODE_PRIVATE);
        SharedPreferences name_preferences = getSharedPreferences("Name_Output", MODE_PRIVATE);
        SharedPreferences num_preferences = getSharedPreferences("Num_Output", MODE_PRIVATE);

        String address = add_preferences.getString("add_1", "");
        String name = name_preferences.getString("name_1", "");
        String phoneNo = num_preferences.getString("num_1", "");
        String sms = "[생존 알림 어플] "+ name + "님의 생존이 확인되고 있지 않습니다. 방문 확인이 필요합니다.\n" + "주소 : " + address;

        SmsManager smsManager = SmsManager.getDefault();
        ArrayList<String> part_sms = smsManager.divideMessage(sms);
        //Toast.makeText(RingtonePlayingService.this,sms,Toast.LENGTH_SHORT).show();

        if (phoneNo.length() > 0) {
            try {
                //보호자에게 SMS 전송
                smsManager.sendMultipartTextMessage(phoneNo, null, part_sms, null, null);
                Toast.makeText(getApplicationContext(), "보호자에게 신고 완료", Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "SMS 발송 실패", Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }
        } else {
            try {
                //119에 SMS 전송 --> 허위신고 방지위해 변경 전
                smsManager.sendMultipartTextMessage(phoneNo, null, part_sms, null, null);
                Toast.makeText(getApplicationContext(), "112에 신고 완료", Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "SMS 발송 실패", Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }
        }

    }

    public boolean checkPermission(String permission){
        int check = ContextCompat.checkSelfPermission(this, permission);
        return (check == PackageManager.PERMISSION_GRANTED);
    }

}