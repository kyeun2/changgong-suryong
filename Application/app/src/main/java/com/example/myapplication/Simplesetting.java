package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Simplesetting extends AppCompatActivity {

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
        setContentView(R.layout.simplesetting);

        Button before = (Button)findViewById(R.id.button17);
        Button After = (Button)findViewById(R.id.button18);

        After.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(), Simplesetting1.class
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
