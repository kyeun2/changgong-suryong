package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class Simplesetting2 extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(
                getApplicationContext(), Simplesetting1.class
        );
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simplesetting2);

        final EditText name = (EditText)findViewById(R.id.editText_num);
        Button before = (Button)findViewById(R.id.button9);
        Button After = (Button)findViewById(R.id.button10);

        After.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String InputName = name.getText().toString();
                //데이터 저장
                SharedPreferences name_preferences = getSharedPreferences("Name_Output", MODE_PRIVATE);
                SharedPreferences.Editor editor2 = name_preferences.edit();
                editor2.putString("name_1", InputName);
                editor2.commit();

                //데이터 다른 레이아웃 넘기기
                Intent intent = new Intent(Simplesetting2.this, MainActivity.class);
                intent.putExtra("Name_Output", InputName);
                startActivity(intent);

                //다음페이지
                Intent intent1 = new Intent(
                        getApplicationContext(), Simplesetting3.class
                );
                startActivity(intent1);
                finish();
            }
        });

        before.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(), Simplesetting1.class
                );
                startActivity(intent);
                finish();
            }
        });

    }
}
