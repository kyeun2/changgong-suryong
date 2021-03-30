package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static Context checkContext;
    String[] permission_list = {
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.SEND_SMS,
            Manifest.permission.READ_PHONE_STATE
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkContext = this;
        // 권한확인
        checkPermission();

        SharedPreferences prefs = getSharedPreferences("isFirstRun", Activity.MODE_PRIVATE);
        boolean isFirstRun = prefs.getBoolean("isFirstRun", true);
        if(isFirstRun)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("처음 실행했습니다.");
            builder.setMessage("사용설명을 읽어주시고, 간편설정을 버튼을 눌러 사용자 정보를 등록해주십시오.");
            builder.setNeutralButton("확인", null);
            builder.create().show();
            Toast.makeText(getApplicationContext(),"test",Toast.LENGTH_LONG).show();

            prefs.edit().putBoolean("isFirstRun", false).apply();
        }

        TextView addressView = (TextView)findViewById(R.id.text_address);
        TextView nameView = (TextView)findViewById(R.id.text_Name);
        TextView numView = (TextView)findViewById(R.id.text_num);
        TextView dayView = (TextView)findViewById(R.id.text_day);
        Button b = (Button) findViewById(R.id.button1);
        Button b1 = (Button) findViewById(R.id.button2);
        Button b2 = (Button) findViewById(R.id.button3);
        Button b3 = (Button) findViewById(R.id.button4);
        Intent intent = getIntent();


        //String add = intent.getStringExtra("Address_Output");
        SharedPreferences add_preferences = getSharedPreferences("Address_Output", MODE_PRIVATE);
        SharedPreferences name_preferences = getSharedPreferences("Name_Output", MODE_PRIVATE);
        SharedPreferences num_preferences = getSharedPreferences("Num_Output", MODE_PRIVATE);
        SharedPreferences day_preferences = getSharedPreferences("Day_Output", MODE_PRIVATE);

        //불러오기
        String add_perf = add_preferences.getString("add_1", "");
        String name_perf = name_preferences.getString("name_1", "");
        String num_perf = num_preferences.getString("num_1", "");
        String day_perf = day_preferences.getString("day_1", "");

        addressView.setText(add_perf);
        nameView.setText(name_perf);
        numView.setText(num_perf);
        dayView.setText(day_perf);



        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(), Simplesetting.class
                );
                startActivity(intent);
                finish();
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(), Sub1.class
                );
                startActivity(intent);
                finish();

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(), Detailsetting.class
                );
                startActivity(intent);
                finish();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(), Alarmreport.class
                );
                startActivity(intent);
                finish();
            }
        });

    }


    public void checkPermission(){
        // 현재 안드로이드 버전이 6.0 미만이면 메서드를 종료
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
            return;
        } else {
            for (String permission : permission_list) {
                int chk = checkCallingOrSelfPermission(permission);

                if (chk == PackageManager.PERMISSION_DENIED) {
                    //권한 허용 여부를 확인하는 창을 띄운다
                    requestPermissions(permission_list, 0);
                }
            }
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==0)
        {
            for(int i=0; i<grantResults.length; i++)
            {
                if(grantResults[i]==PackageManager.PERMISSION_GRANTED){

                } else {
                    // 하나라도 허용되지 않는다면
                    Toast.makeText(getApplicationContext(),"앱 권한설정이 필요합니다",Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        }
    }




}



