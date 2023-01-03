package com.example.stickyheaderrecyclervview;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public interface SectionCallback {
    boolean isHeader(int position);

    View getHeaderLayoutView(RecyclerView list, int position);
}
