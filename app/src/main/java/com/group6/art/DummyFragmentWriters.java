package com.group6.art;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
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
        /*
        dummyList.add(new DummyItem(R.drawable.ic_launcher_background, "Palm Beach", "Saturday, AUG ","3.46"));
        dummyList.add(new DummyItem(R.drawable.ic_launcher_background, "Palm Bea", "Saturday, AU","3.46"));
        dummyList.add(new DummyItem(R.drawable.ic_launcher_background, "Palm Beach ", "Saturday, AUG","3.46"));
        dummyList.add(new DummyItem(R.drawable.ic_launcher_background, "Palm Beach ", "Saturday,","3.46"));
        dummyList.add(new DummyItem(R.drawable.ic_launcher_background, "Palm Beac", "Saturday, AUG and","3.46"));
        dummyList.add(new DummyItem(R.drawable.ic_launcher_background, "Palm od Fest", "Saturdayode Isand","3.46"));
        dummyList.add(new DummyItem(R.drawable.ic_launcher_background, "Palm Beach Food Fest", "Saturday, AUG 23 - AUG 25 @ Rode Island","3.46"));
        dummyList.add(new DummyItem(R.drawable.ic_launcher_background, "Palm Beach Food Fest", "Saturday, AUG 23 - AUG 25 @ Rode Island","3.46"));
           */
        dummyAdapter = new DummyAdapter(dummyList, getContext());
        dummyAdapter.setHasStableIds(true);
        recyclerView.setAdapter(dummyAdapter);

        return view;
    }
}