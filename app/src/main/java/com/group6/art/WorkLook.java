package com.group6.art;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
        ImageView back_image,heart,work_image,profile_image,comment_profile_image;
        Boolean heart_check;
        TextView work_title,work_writer;
        Button score;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.work_lookup);
            Intent intent=getIntent();
            heart=(ImageView)findViewById(R.id.heart);
            work_image=(ImageView) findViewById(R.id.work_image);
            work_title=(TextView)findViewById(R.id.work_title);
            work_writer=(TextView)findViewById(R.id.work_writer);
            profile_image=(ImageView)findViewById(R.id.profile_image);
            comment_profile_image=(ImageView)findViewById(R.id.comment_profile_image);
            score=(Button)findViewById(R.id.score_btn);
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

            //
            Bundle extras = getIntent().getExtras();
            String s = extras.getString("title");
            String s1 = extras.getString("writer");
            String s2 = extras.getString("score");
            byte[] byteArray = getIntent().getByteArrayExtra("image");

            Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            //
            byte[] byteArray1 = getIntent().getByteArrayExtra("writerimage");
            Bitmap bitmap1 = BitmapFactory.decodeByteArray(byteArray1, 0, byteArray1.length);
            profile_image.setImageBitmap(bitmap1);
            comment_profile_image.setImageBitmap(bitmap1);
            //
            score.setText(s2);
           work_title.setText(s);
           work_writer.setText(s1);
            work_image.setImageBitmap(bitmap);

            //



        }
    }
