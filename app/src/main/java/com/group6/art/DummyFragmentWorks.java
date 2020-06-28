package com.group6.art;

import android.annotation.SuppressLint;
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
        dummyList.add(new DummyItem(R.drawable.writer1, "Palm Beach", "리니 일러스트","3.46"));
        dummyList.add(new DummyItem(R.drawable.writer2, "Palm Bea", "제2의 피카소","3.46"));
        dummyList.add(new DummyItem(R.drawable.writer5, "Palm Beach ", "그림매니아1","3.46"));
        dummyList.add(new DummyItem(R.drawable.ic_launcher_background, "Palm Beach ", "David Hockney","3.46"));
        dummyList.add(new DummyItem(R.drawable.writer6, "Palm Beac", "STAR DREAM3","3.46"));
        dummyList.add(new DummyItem(R.drawable.ic_launcher_background, "Palm od Fest", "화가 준비생","3.46"));
        dummyList.add(new DummyItem(R.drawable.ic_launcher_background, "Palm Beach Food Fest", "LJ 아티스트","3.46"));
        dummyList.add(new DummyItem(R.drawable.ic_launcher_background, "Palm Beach Food Fest", "사랑의 그림방","3.46"));

        dummyAdapter = new DummyAdapter(dummyList, getContext());
        dummyAdapter.setHasStableIds(true);


        recyclerView.setAdapter(dummyAdapter);

        return view;
    }
}