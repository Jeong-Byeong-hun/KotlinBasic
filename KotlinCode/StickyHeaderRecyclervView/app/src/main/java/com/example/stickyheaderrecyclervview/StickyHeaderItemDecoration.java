package com.example.stickyheaderrecyclervview;

import android.graphics.Canvas;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StickyHeaderItemDecoration extends RecyclerView.ItemDecoration {
    private SectionCallback sectionCallback;

    public StickyHeaderItemDecoration(SectionCallback sectionCallback) {
        this.sectionCallback = sectionCallback;
    }

    @Override
    public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        if (parent.getChildAt(0) == null) {
            return;
        }

        View topChild = parent.getChildAt(0);

        int topChildPosition = parent.getChildAdapterPosition(topChild);
        if (topChildPosition == RecyclerView.NO_POSITION) {
            return;
        }

        /* Header */
        View currentHeader = sectionCallback.getHeaderLayoutView(parent, topChildPosition);

        fixLayoutSize(parent, currentHeader, topChild.getMeasuredHeight());

        int contactPoint = currentHeader.getBottom();

        if (getChildContact(parent, contactPoint) == null) {
            return;
        }
        View childInContact = getChildContact(parent, contactPoint);
        int childAdapterPosition = parent.getChildAdapterPosition(childInContact);
        if (childAdapterPosition == -1) {
            return;
        }
        
        if (sectionCallback.isHeader(childAdapterPosition)){
            moveHeader(c, currentHeader, childInContact);
        }else {
            drawHeader(c, currentHeader);
        }

        

    }

    private void drawHeader(Canvas c, View currentHeader) {
    }

    private void moveHeader(Canvas c, View currentHeader, View childInContact) {
    }

    private View getChildContact(RecyclerView parent, int contactPoint) {
        View childInContact = null;
        for (int i = 0; i < parent.getChildCount(); i++) {
            View child = parent.getChildAt(i);
            if (child.getBottom() > contactPoint) {
                if (child.getTop() <= contactPoint) {
                    childInContact = child;
                    break;
                }
            }
        }

        return childInContact;
    }

    /**
     * Measures the header view to make sure its size is greater than 0 and will be drawn
     * https://yoda.entelect.co.za/view/9627/how-to-android-recyclerview-item-decorations
     */
    private void fixLayoutSize(RecyclerView parent, View currentHeader, int measuredHeight) {
    }


}
