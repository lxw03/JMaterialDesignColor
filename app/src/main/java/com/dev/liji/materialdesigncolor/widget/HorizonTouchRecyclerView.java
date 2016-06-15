package com.dev.liji.materialdesigncolor.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by liji on 16-6-15.
 */
public class HorizonTouchRecyclerView extends RecyclerView {
    public HorizonTouchRecyclerView(Context context) {
        super(context);
    }

    public HorizonTouchRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public HorizonTouchRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    private View currentView;

    private onItemScrollChangeListener onItemScrollChangeListener;

    public void setOnItemScrollChangeListener(onItemScrollChangeListener listener) {
        this.onItemScrollChangeListener = listener;
    }

    public interface onItemScrollChangeListener {

        void onChange(View view, int position);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        currentView = getChildAt(0);

        if (onItemScrollChangeListener != null) {
            onItemScrollChangeListener.onChange(currentView, getChildPosition(currentView));
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        if (e.getAction() == MotionEvent.ACTION_MOVE)
        {
            currentView = getChildAt(0);
            // Log.e("TAG", getChildPosition(getChildAt(0)) + "");
            if (onItemScrollChangeListener != null)
            {
                onItemScrollChangeListener.onChange(currentView,
                        getChildPosition(currentView));

            }

        }

        return super.onTouchEvent(e);

    }
}
