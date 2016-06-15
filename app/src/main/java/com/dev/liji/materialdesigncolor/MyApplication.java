package com.dev.liji.materialdesigncolor;

import android.app.Application;

import org.xutils.x;

/**
 * Created by liji on 16-6-15.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(false);
    }
}
