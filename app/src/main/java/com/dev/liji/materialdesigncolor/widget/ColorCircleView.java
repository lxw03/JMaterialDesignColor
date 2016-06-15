package com.dev.liji.materialdesigncolor.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.dev.liji.materialdesigncolor.R;
import com.dev.liji.materialdesigncolor.utils.SystemUtils;


/**
 * 作者：liji on 2016/2/19 11:09
 * 邮箱：lijiwork@sina.com
 * 自定义放缩圆
 */

public class ColorCircleView extends View {

    private Paint mPaint;

    //边界颜色
    private int circleBorderColor;

    //填充颜色
    private int circleSoildColor;

    //半径
    private float circleRadius;

    public ColorCircleView(Context context) {
        this(context, null);
    }

    public ColorCircleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ColorCircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.color_circleview);
        circleBorderColor = typedArray.getColor(R.styleable.color_circleview_circle_border_color, Color.WHITE);
        circleSoildColor = typedArray.getColor(R.styleable.color_circleview_circle_soild_color, Color.BLUE);
        circleRadius = typedArray.getDimension(R.styleable.color_circleview_circle_radius, 30);
        circleRadius = SystemUtils.dip2px(context, circleRadius);
        typedArray.recycle();
        initView(context);
    }

    private void initView(Context context) {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(circleSoildColor);
        int cx = getWidth() / 2;
        int cy = getHeight() / 2;
        canvas.drawCircle(cx, cy, circleRadius, mPaint);
    }

    public void setCircleRadius(int width) {
        this.circleRadius = width;
    }

    public void setCircleSoildColor(int color) {
        this.circleSoildColor = color;
    }

    public void setCircleBorderColor(int color) {
        this.circleBorderColor = color;
    }
}
