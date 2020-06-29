package com.group6.art;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

    public class WorkLook extends AppCompatActivity {
        ImageView back_image,heart;
        Boolean heart_check;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.work_lookup);
            Intent intent=getIntent();
            heart=findViewById(R.id.heart);
            heart_check=false;
            back_image=findViewById(R.id.back_image);
            back_image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });


            heart.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if(heart_check==false) {
                        heart.setImageResource(R.drawable.heart_yes2);
                        heart_check=true;
                    }
                    else{
                        heart.setImageResource(R.drawable.heart_no2);
                        heart_check=false;
                    }
                    return false;
                }
            });

        }
    }
