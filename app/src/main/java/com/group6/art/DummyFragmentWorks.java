package com.group6.art;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

import static com.firebase.ui.auth.AuthUI.getApplicationContext;

public class DummyFragmentWorks extends Fragment {
    int dummyColor;
    DummyAdapter dummyAdapter;
    ArrayList<DummyItem> dummyList;
    RecyclerView recyclerView;




    // 파이어베이스 스토리지 이미지 가져오기

    public DummyFragmentWorks() {
    }

    @SuppressLint("ValidFragment")
    public DummyFragmentWorks(int color) {
        this.dummyColor = color;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dummy, container, false);

        final FrameLayout frameLayout = view.findViewById(R.id.frame_layout_dummy);
        frameLayout.setBackgroundColor(dummyColor);

        recyclerView = view.findViewById(R.id.recycler_dummy);

        StaggeredGridLayoutManager staggeredGridLayoutManager  = new StaggeredGridLayoutManager(2,1);
        recyclerView.setLayoutManager(staggeredGridLayoutManager );
        staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        RecyclerView.ItemAnimator animator = recyclerView.getItemAnimator();
        if (animator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) animator).setSupportsChangeAnimations(false);
        }
        dummyList = new ArrayList<>();
        dummyList.add(new DummyItem(R.drawable.work1, "스파클", "LJ 아티스트","9.53",R.drawable.ljartist));
        dummyList.add(new DummyItem(R.drawable.work2, "보석같은 눈", "제2의 피카소","9.48",R.drawable.picaso));
        dummyList.add(new DummyItem(R.drawable.work3, "봄과 벚꽃, 너", "그림매니아1","9.37",R.drawable.mania));
        dummyList.add(new DummyItem(R.drawable.work4, "노을 위 설산", "David Hockney","9.32",R.drawable.david));
        dummyList.add(new DummyItem(R.drawable.work8, "공허한 정류장", "사랑의 그림방","9.27",R.drawable.love));
        dummyList.add(new DummyItem(R.drawable.work6, "호수와 가을", "화가 준비생","9.21",R.drawable.hwaga));
        dummyList.add(new DummyItem(R.drawable.work7, "사계절이 흐른다", "리니 일러스트","9.09",R.drawable.rinny));
        dummyList.add(new DummyItem(R.drawable.work5, "꽃잎 만개", "STAR DREAM3","8.91",R.drawable.dream3));
        dummyAdapter = new DummyAdapter(dummyList, getContext());
        dummyAdapter.setHasStableIds(true);
        recyclerView.setAdapter(dummyAdapter);


        return view;
    }
}