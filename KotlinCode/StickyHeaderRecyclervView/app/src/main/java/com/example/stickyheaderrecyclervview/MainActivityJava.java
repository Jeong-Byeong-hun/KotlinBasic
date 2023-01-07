package com.example.stickyheaderrecyclervview;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stickyheaderrecyclervview.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivityJava extends AppCompatActivity {
    private StickyHeaderAdapter stickyHeaderAdapter;
    private ArrayList<EventVo> eventList = new ArrayList<>();
    ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setData();
        setAdapter();
    }

    private void setAdapter() {
        stickyHeaderAdapter = new StickyHeaderAdapter();
        stickyHeaderAdapter.setEventList(eventList);
        binding.recyclerView.setAdapter(stickyHeaderAdapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext()));

        binding.recyclerView.addItemDecoration(new StickyHeaderItemDecoration(getSectionCallBack()));

    }

    private SectionCallback getSectionCallBack(){
        return new SectionCallback() {
            @Override
            public boolean isHeader(int position) {
                return stickyHeaderAdapter.isHeader(position);
            }

            @Override
            public View getHeaderLayoutView(RecyclerView list, int position) {
                return stickyHeaderAdapter.getHeaderView(list, position);
            }
        };
    }

    private void setData() {
        for (int i = 0; i < 100; i++) {
            EventVo eventVo = new EventVo(i);
            eventList.add(eventVo);
        }
    }
}
