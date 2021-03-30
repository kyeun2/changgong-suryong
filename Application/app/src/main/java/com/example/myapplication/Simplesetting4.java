package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Simplesetting4 extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(
                getApplicationContext(), Simplesetting3.class
        );
        startActivity(intent);
    }

    @Override
    protected void  onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simplesetting4);

        TextView add = (TextView)findViewById(R.id.add);
        TextView name = (TextView)findViewById(R.id.name);
        TextView num = (TextView)findViewById(R.id.num);

        //String add = intent.getStringExtra("Address_Output");
        SharedPreferences add_preferences = getSharedPreferences("Address_Output", MODE_PRIVATE);
        SharedPreferences name_preferences = getSharedPreferences("Name_Output", MODE_PRIVATE);
        SharedPreferences num_preferences = getSharedPreferences("Num_Output", MODE_PRIVATE);

        //불러오기
        String add_perf = add_preferences.getString("add_1", "");
        String name_perf = name_preferences.getString("name_1", "");
        String num_perf = num_preferences.getString("num_1", "");

        add.setText(add_perf);
        name.setText(name_perf);
        num.setText(num_perf);

        Button before = (Button)findViewById(R.id.button13);
        Button After = (Button)findViewById(R.id.button14);

        After.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(), Simplesetting5.class
                );
                startActivity(intent);
            }
        });

        before.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(), Simplesetting3.class
                );
                startActivity(intent);
            }
        });
    }
}
