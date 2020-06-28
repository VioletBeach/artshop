package com.group6.art;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewPager viewPager;
    TabLayout tabLayout;
    Button assessbtn,insertbtn;
    ImageView userPage,menuImage,logo;
    int point=0;
    static boolean isFirst=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //탭뷰,리사이러클 뷰
        initViewPager();
        initTabLayout();


        //로딩화면 2초동안 불러오기
        if(isFirst==true) {
            Intent intent = new Intent(this, LoadingActivity.class);
            startActivity(intent);
        }
        assessbtn=(Button)findViewById(R.id.assess_btn);
        insertbtn=(Button)findViewById(R.id.insert_btn);
        userPage=(ImageView)findViewById(R.id.userPage);
        menuImage=(ImageView)findViewById(R.id.menu_image);
        logo=(ImageView)findViewById(R.id.logo);
        //버튼
        assessbtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    assessbtn.setBackgroundResource(R.drawable.btn_set_touch);
                } else if(event.getAction() == MotionEvent.ACTION_UP) {
                    assessbtn.setBackgroundResource(R.drawable.btn_set);
                    Intent intent = new Intent(MainActivity.this,AssessWorks.class);
                    intent.putExtra("point", point);
                    startActivityForResult(intent,1234);
                }
                return false;
            }
        });
        insertbtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    insertbtn.setBackgroundResource(R.drawable.btn_set_touch);
                } else if(event.getAction() == MotionEvent.ACTION_UP) {
                    insertbtn.setBackgroundResource(R.drawable.btn_set);
                    Intent intent = new Intent(getApplicationContext(),InsertWorks.class);
                    startActivity(intent);
                }
                return false;
            }
        });
        //버튼끝
        userPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),UserPageActivity.class);
                startActivity(intent);
            }
        });

        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        menuImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(MainActivity.this , menuImage);
                MenuInflater inf = popup.getMenuInflater();
                inf.inflate(R.menu.menu, popup.getMenu());
                popup.show();
            }
        });
    }
    @Override
    protected void onPause(){
        super.onPause();
        if(isFirst)
            isFirst=false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    //탭뷰,리사이러클뷰
    private void initViewPager() {
        viewPager = findViewById(R.id.viewpager_home);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new DummyFragmentWorks(ContextCompat.getColor(this, R.color.bg)), "작 품");
        adapter.addFrag(new DummyFragmentWriters(ContextCompat.getColor(this, R.color.bg)), "작 가");
        viewPager.setAdapter(adapter);
    }

    private void initTabLayout() {
        tabLayout = findViewById(R.id.tabs_home);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private static class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


    // <- 탭뷰 리사이러클뷰 끝
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1234 && resultCode == RESULT_OK){
            point = data.getIntExtra("point",point);
        }else{
        }
    }
}
