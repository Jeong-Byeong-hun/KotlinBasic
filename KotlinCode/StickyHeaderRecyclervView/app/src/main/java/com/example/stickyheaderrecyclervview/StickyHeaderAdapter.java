package com.example.stickyheaderrecyclervview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stickyheaderrecyclervview.databinding.Item1Binding;
import com.example.stickyheaderrecyclervview.databinding.Item2Binding;

import java.util.ArrayList;

public class StickyHeaderAdapter extends RecyclerView.Adapter<StickyHeaderViewHolder> {
    private ArrayList<EventVo> eventList = new ArrayList<>();

    @NonNull
    @Override
    public StickyHeaderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StickyHeaderViewHolder(Item1Binding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull StickyHeaderViewHolder holder, int position) {
        holder.bind(eventList.get(position));
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public ArrayList<EventVo> getEventList() {
        return eventList;
    }

    public void setEventList(ArrayList<EventVo> eventList) {
        this.eventList = eventList;
        notifyDataSetChanged();
    }

    public boolean isHeader(int pos) {
        return eventList.get(pos).isHeader();
    }

    public View getHeaderView(RecyclerView list, int pos) {
        EventVo vo = eventList.get(pos);

        Item2Binding binding = Item2Binding.inflate(LayoutInflater.from(list.getContext()), list, false);
        binding.date.setText(vo.getDate() + "월");
        return binding.date.getRootView();
    }
}
