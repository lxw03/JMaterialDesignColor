package com.dev.liji.materialdesigncolor.activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.xutils.x;

public abstract class ActivityBase extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutViewId());
        x.view().inject(this);
        initView();
        initData();
    }

    public abstract void initView();

    public abstract void initData();

    public abstract int getLayoutViewId();

}
