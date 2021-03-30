package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Simplesetting3 extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(
                getApplicationContext(), Simplesetting2.class
        );
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simplesetting3);

        final EditText num = (EditText)findViewById(R.id.editText_num);
        Button before = (Button)findViewById(R.id.button11);
        Button After = (Button)findViewById(R.id.button12);

        After.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String InputNum = num.getText().toString();
                //데이터 저장
                SharedPreferences num_preferences = getSharedPreferences("Num_Output", MODE_PRIVATE);
                SharedPreferences.Editor editor3 = num_preferences.edit();
                editor3.putString("num_1", InputNum);
                editor3.commit();

                //데이터 다른 레이아웃 넘기기
                Intent intent = new Intent(Simplesetting3.this, MainActivity.class);
                intent.putExtra("Num_Output", InputNum);
                startActivity(intent);

                //다음페이지
                Intent intent1 = new Intent(
                        getApplicationContext(), Simplesetting4.class
                );
                startActivity(intent1);
                finish();
            }
        });

        before.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(), Simplesetting2.class
                );
                startActivity(intent);
                finish();
            }
        });
    }
}
