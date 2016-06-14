package com.dev.liji.materialdesigncolor.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dev.liji.materialdesigncolor.R;

/**
 * Created by liji on 16-6-14.
 */
public class Headview extends RelativeLayout {

    private LayoutInflater mInflayout;
    private ImageView imgBack;
    private TextView tvTitle;
    private TextView tvAction;
    private final int TYPE_CENTER = 0;
    private final int TYPE_lEFT = -1;
    private final int TYPE_RIGHT = 1;

    public Headview(Context context) {
        super(context);
        initView(context);
    }

    public Headview(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public Headview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {

        mInflayout = LayoutInflater.from(context);
        View view = mInflayout.inflate(R.layout.headview, this);
        imgBack = (ImageView) view.findViewById(R.id.headview_img_back);
        tvAction = (TextView) view.findViewById(R.id.headview_tv_action);
        tvTitle = (TextView) view.findViewById(R.id.headview_tv_title);
    }


    /**
     * 设置标题
     *
     * @param title
     */
    public void setTitle(String title) {
        setClick(TYPE_CENTER, title, null);
    }

    /**
     * 设置右边文字功能
     *
     * @param content
     * @param listener
     */
    public void setRightTextAction(String content, OnClickListener listener) {
        setClick(TYPE_RIGHT, content, listener);
    }

    /**
     * 返回
     *
     * @param listener
     */
    public void setBackClick(OnClickListener listener) {
        setClick(TYPE_lEFT, null, listener);
    }

    private void setClick(Integer type, String content, OnClickListener listener) {

        if (type == TYPE_lEFT) {
            if (listener != null) {
                imgBack.setVisibility(View.VISIBLE);
                imgBack.setOnClickListener(listener);
            } else {
                imgBack.setVisibility(View.GONE);
            }
        } else if (type == TYPE_CENTER) {
            tvTitle.setText("" + content);
        } else if (type == TYPE_RIGHT) {
            tvAction.setText(content);
            if (listener != null) {
                tvAction.setOnClickListener(listener);
            }
        }
    }

}
