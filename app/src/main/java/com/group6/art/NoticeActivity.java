package com.group6.art;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class NoticeActivity extends AppCompatActivity {
    ImageView back_image;
    View appcolor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notice);  // layout xml 과 자바파일을 연결
        appcolor=(View)findViewById(R.id.appcolor);
        appcolor.setBackgroundColor(Color.WHITE);
        back_image=(ImageView) findViewById(R.id.back_image);
        back_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    } // end onCreate()
} // en



