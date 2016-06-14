package com.dev.liji.materialdesigncolor.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.dev.liji.materialdesigncolor.R;
import com.dev.liji.materialdesigncolor.model.ColorFirstPattle;
import com.dev.liji.materialdesigncolor.widget.Headview;

public class SecondLayoutActivity extends ActivityBase {

    private int position = 0;
    Headview headview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = this.getIntent().getIntExtra("position", 0);
    }

    @Override
    public void initView() {

        headview = (Headview) findViewById(R.id.headview);
        headview.setTitle("" + ColorFirstPattle.nameFirst[position]);
        headview.setBackClick(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        headview.setRightTextAction("预览", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SecondLayoutActivity.this, "预览", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public int getLayoutViewId() {
        return R.layout.activity_second_layout;
    }
}
