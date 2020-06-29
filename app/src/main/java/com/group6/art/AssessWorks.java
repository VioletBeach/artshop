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

import com.google.firebase.database.annotations.Nullable;

public class AssessWorks extends AppCompatActivity {
    ImageView heart,backImage,work_image;
    TextView scoreText,work_title;
    RatingBar ratingBar;
    Boolean heart_check;
    Button finish_btn,next_btn;
    float score;
    int point=0;
    int[] resource=new int[]{R.drawable.work1,R.drawable.work2,R.drawable.work3,R.drawable.work4,R.drawable.work5,
R.drawable.work6,R.drawable.work7,R.drawable.work8};
    String[] randomtitle=new String[]{"스파클","보석같은 눈","봄과 벚꽃, 너","노을 위 설산","꽃잎 만개","호수와 가을","사계절이 흐른다",
    "공허한 정류장"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assess_works);
        Intent intent=getIntent();
        point=intent.getIntExtra("point",point);
        heart=findViewById(R.id.heart);
        scoreText=findViewById(R.id.asses_score_text);
        ratingBar=findViewById(R.id.rating_bar);
        backImage=findViewById(R.id.back_image);
        work_image=(ImageView)findViewById(R.id.work_image);
        work_title=(TextView)findViewById(R.id.work_title);
        finish_btn=findViewById(R.id.finish_btn);
        next_btn=findViewById(R.id.next_btn);
        heart_check=false;



            int random = (int) (java.lang.Math.random() * 8);
            work_image.setImageResource(resource[random]);
            work_title.setText(randomtitle[random]);


        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ratingBar.getRating()==0) {
                    Toast.makeText(getApplicationContext(), "별점을 선택하세요", Toast.LENGTH_SHORT).show();
                }
                    else {
                    point++;
                    Toast.makeText(getApplicationContext(), ""+(int)ratingBar.getRating()*2+"점으로 평가가 완료되었습니다.", Toast.LENGTH_SHORT).show();
                    int random = (int) (java.lang.Math.random() * 8);
                    work_image.setImageResource(resource[random]);
                    work_title.setText(randomtitle[random]);
                    ratingBar.setRating(0);
                    heart.setImageResource(R.drawable.heart_no);
                    heart_check = false;
                }
                //

            }
        });
        finish_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ratingBar.getRating()==0){
                    Toast.makeText(getApplicationContext(),"별점을 선택하세요",Toast.LENGTH_SHORT).show();
                }
                else
                show();
            }
        });
        heart.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(heart_check==false) {
                    heart.setImageResource(R.drawable.heart_yes);
                    heart_check=true;
                }
                else{
                    heart.setImageResource(R.drawable.heart_no);
                    heart_check=false;
                }
                return false;
            }
        });

        ratingBar.setOnRatingBarChangeListener(new Listener());
    }

class Listener implements RatingBar.OnRatingBarChangeListener
{
    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
        int score;
        score=(int)(ratingBar.getRating()*2);
        scoreText.setText(score+"/"+10+"점");
    }
}
    void show()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("평가를 마치시겠습니까?");
        builder.setMessage("\n 완료 후 포인트 : "+(point+1));
        builder.setPositiveButton("예",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        point++;
                        Toast.makeText(getApplicationContext(),"평가가 완료되었습니다.",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();//startActivity()를 할것이 아니므로 그냥 빈 인텐트로 만듦
                        intent.putExtra("point",point);
                        setResult(RESULT_OK,intent);
                        finish();
                    }
                });
        builder.setNegativeButton("아니오",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
        builder.show();
    }

}
