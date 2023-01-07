package com.example.stickyheaderrecyclervview;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stickyheaderrecyclervview.databinding.Item1Binding;

public class StickyHeaderViewHolder extends RecyclerView.ViewHolder {
    private Item1Binding binding;

    public StickyHeaderViewHolder(Item1Binding binding) {
        super(binding.date.getRootView());
        this.binding = binding;
    }

    public void bind(EventVo vo) {
        binding.title.setText(String.valueOf(vo.getValue()));
        binding.date.setText( vo.getDate() +"월");
        if (vo.isHeader()) {
            binding.date.setVisibility(View.VISIBLE);
        } else {
            binding.date.setVisibility(View.GONE);
        }

    }

}
