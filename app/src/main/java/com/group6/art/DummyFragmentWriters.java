package com.group6.art;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class DummyFragmentWriters extends Fragment {
    int dummyColor;
    DummyAdapter dummyAdapter;
    ArrayList<DummyItem> dummyList;
    RecyclerView recyclerView;

    public DummyFragmentWriters() {
    }

    @SuppressLint("ValidFragment")
    public DummyFragmentWriters(int color) {
        this.dummyColor = color;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dummy, container, false);

        final FrameLayout frameLayout = view.findViewById(R.id.frame_layout_dummy);
        frameLayout.setBackgroundColor(dummyColor);

        recyclerView = view.findViewById(R.id.recycler_dummy);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        RecyclerView.ItemAnimator animator = recyclerView.getItemAnimator();
        if (animator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) animator).setSupportsChangeAnimations(false);
        }
        dummyList = new ArrayList<>();

        dummyList.add(new DummyItem(R.drawable.writer10, "리니 일러스트", "작품수 : 13","9.31",R.drawable.rinny));
        dummyList.add(new DummyItem(R.drawable.writer3, "제2의 피카소", "작품수 : 8","9.16",R.drawable.picaso));
        dummyList.add(new DummyItem(R.drawable.writer4, "그림매니아1", "작품수 : 10","8.92",R.drawable.mania));
        dummyList.add(new DummyItem(R.drawable.writer5, "David Hockney", "작품수 : 6","8.79",R.drawable.david));
        dummyList.add(new DummyItem(R.drawable.writer6, "사랑의 그림방", "작품수 : 13","8.72",R.drawable.love));
        dummyList.add(new DummyItem(R.drawable.writer7, "STAR DREAM3", "작품수 : 8","8.64",R.drawable.dream3));
        dummyList.add(new DummyItem(R.drawable.writer1, "화가 준비생", "작품수 : 10","8.51",R.drawable.hwaga));
        dummyList.add(new DummyItem(R.drawable.writer9, "LJ 아티스트", "작품수 : 11","8.44",R.drawable.ljartist));
        dummyAdapter= new DummyAdapter(dummyList, getContext());
        dummyAdapter.setHasStableIds(true);
        recyclerView.setAdapter(dummyAdapter);

        return view;
    }
}