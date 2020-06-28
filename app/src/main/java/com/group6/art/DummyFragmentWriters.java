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

        dummyList = new ArrayList<>();

        dummyList.add(new DummyItem(R.drawable.ic_launcher_background, "제2의 피카소", "작품수 : 7","9.47"));
        dummyList.add(new DummyItem(R.drawable.ic_launcher_background, "리니 일러스트", "작품수 : 13","9.31"));
        dummyList.add(new DummyItem(R.drawable.ic_launcher_background, "JYR PARK5331", "작품수 : 8","9.16"));
        dummyList.add(new DummyItem(R.drawable.ic_launcher_background, "그림매니아1", "작품수 : 10","8.92"));
        dummyList.add(new DummyItem(R.drawable.ic_launcher_background, "David Hockney", "작품수 : 6","8.79"));
        dummyList.add(new DummyItem(R.drawable.ic_launcher_background, "꿈을 꾸는 작가", "작품수 : 13","8.72"));
        dummyList.add(new DummyItem(R.drawable.ic_launcher_background, "STAR DREAM3", "작품수 : 8","8.64"));
        dummyList.add(new DummyItem(R.drawable.ic_launcher_background, "나름 화가 준비생", "작품수 : 10","8.51"));
        dummyAdapter = new DummyAdapter(dummyList, getContext());
        dummyAdapter.setHasStableIds(true);
        recyclerView.setAdapter(dummyAdapter);

        return view;
    }
}