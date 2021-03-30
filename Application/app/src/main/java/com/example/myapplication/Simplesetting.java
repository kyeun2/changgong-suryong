package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Simplesetting extends AppCompatActivity {

    @Override
<<<<<<< HEAD
    public void onBackPressed() {
        Intent intent = new Intent(
                getApplicationContext(), MainActivity.class
        );
        startActivity(intent);
        finish();
    }

    @Override
=======
>>>>>>> 84367abe340ad00909dee7da0c7a4bdfa42af73f
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
<<<<<<< HEAD
                finish();
=======
>>>>>>> 84367abe340ad00909dee7da0c7a4bdfa42af73f
            }
        });

        before.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(), MainActivity.class
                );
                startActivity(intent);
<<<<<<< HEAD
                finish();
=======
>>>>>>> 84367abe340ad00909dee7da0c7a4bdfa42af73f
            }
        });
    }
}
