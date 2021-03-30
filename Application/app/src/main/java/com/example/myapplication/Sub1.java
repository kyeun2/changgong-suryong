package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Sub1 extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(
                getApplicationContext(), MainActivity.class
        );
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub_1);


        final TextView textView203 = (TextView)findViewById(R.id.textView203);
        final TextView textView212 = (TextView)findViewById(R.id.textView212);

        final ScrollView scrollView = (ScrollView)findViewById(R.id.scrollView111);

        final TextView textView211 = (TextView)findViewById(R.id.textView211);
        final TextView textView202 = (TextView)findViewById(R.id.textView202);

        final TextView textView204 = (TextView)findViewById(R.id.textView204);
        final TextView textView214 = (TextView)findViewById(R.id.textView214);

        final TextView textView205 = (TextView)findViewById(R.id.textView205);
        final TextView textView216 = (TextView)findViewById(R.id.textView216);

        final TextView textView206 = (TextView)findViewById(R.id.textView206);
        final TextView textView217 = (TextView)findViewById(R.id.textView217);

        final TextView textView207 = (TextView)findViewById(R.id.textView207);
        final TextView textView219 = (TextView)findViewById(R.id.textView219);

        final TextView textView208 = (TextView)findViewById(R.id.textView208);
        final TextView textView225 = (TextView)findViewById(R.id.textView225);

        final TextView textView209 = (TextView)findViewById(R.id.textView209);
        final TextView textView226 = (TextView)findViewById(R.id.textView226);



        textView203.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                scrollToView(textView212, scrollView, 0);
            }
        });

        textView202.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                scrollToView(textView211, scrollView, 0);
            }
        });

        textView204.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                scrollToView(textView214, scrollView, 0);
            }
        });

        textView205.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                scrollToView(textView216, scrollView, 0);
            }
        });textView206.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                scrollToView(textView217, scrollView, 0);
            }
        });textView207.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                scrollToView(textView219, scrollView, 0);
            }
        });textView208.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                scrollToView(textView225, scrollView, 0);
            }
        });
        textView209.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                scrollToView(textView226, scrollView, 0);
            }
        });





    }

    public static void scrollToView(View view, final ScrollView scrollView, int count) {
        if (view != null && view != scrollView) {
            count += view.getTop();
            scrollToView((View) view.getParent(), scrollView, count);
        } else if (scrollView != null) {
            final int finalCount = count;
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    scrollView.smoothScrollTo(0, finalCount);
                }
            }, 200);
        }
    }
}
