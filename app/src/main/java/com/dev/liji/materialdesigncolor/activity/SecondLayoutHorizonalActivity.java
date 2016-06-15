package com.dev.liji.materialdesigncolor.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.dev.liji.materialdesigncolor.R;
import com.dev.liji.materialdesigncolor.adapter.SecondLayoutAdapter;
import com.dev.liji.materialdesigncolor.adapter.SecondLayoutHorizonalAdapter;
import com.dev.liji.materialdesigncolor.model.ColorFirstPattle;
import com.dev.liji.materialdesigncolor.model.MaterialDesignColor;
import com.dev.liji.materialdesigncolor.widget.Headview;
import com.dev.liji.materialdesigncolor.widget.HorizonTouchRecyclerView;

import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;

public class SecondLayoutHorizonalActivity extends ActivityBase {


    @ViewInject(R.id.headview)
    Headview headview;
    @ViewInject(R.id.recycler_data)
    HorizonTouchRecyclerView recyclerData;
    @ViewInject(R.id.tv_name)
    TextView tvName;

    private Integer positionValue = 0;
    LinearLayoutManager layoutManager;
    SecondLayoutHorizonalAdapter secondLayoutHorizonalAdapter;
    List<MaterialDesignColor> materialDesignColors = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        headview.setBackClick(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerData.setLayoutManager(layoutManager);
    }

    @Override
    public void initData() {
        positionValue = Integer.parseInt(this.getIntent().getStringExtra("positionValue"));
        headview.setTitle("" + ColorFirstPattle.nameFirst[positionValue]);
        headview.setBackgroundCustomeColor(ColorFirstPattle.mdColorFirst[positionValue]);

        materialDesignColors = getMaterialColors();
        secondLayoutHorizonalAdapter = new SecondLayoutHorizonalAdapter(SecondLayoutHorizonalActivity.this, materialDesignColors);
        recyclerData.setAdapter(secondLayoutHorizonalAdapter);
        recyclerData.setOnItemScrollChangeListener(new HorizonTouchRecyclerView.onItemScrollChangeListener() {
            @Override
            public void onChange(View view, int position) {
                Object[][] objects = (Object[][]) ColorFirstPattle.objects[positionValue];
                tvName.setText("" + (String) objects[position][0] + " " + (String) objects[position][1]);
                tvName.setTextColor(Color.parseColor((String) objects[position][1]));
            }
        });

    }

    @Override
    public int getLayoutViewId() {
        return R.layout.activity_second_layout_horizonal;
    }

    public List<MaterialDesignColor> getMaterialColors() {
        Object[][] objects = (Object[][]) ColorFirstPattle.objects[positionValue];
        List<MaterialDesignColor> materialList = new ArrayList<>();
        for (int i = 0; i < objects.length; i++) {
            MaterialDesignColor materialDesignColor = new MaterialDesignColor();
            materialDesignColor.setName(ColorFirstPattle.nameFirst[positionValue]);
            materialDesignColor.setLevel((String) objects[i][0]);
            materialDesignColor.setValue(((String) objects[i][1]));
            materialDesignColor.setMDColor(((Color.parseColor((String) objects[i][1]))));
            materialList.add(materialDesignColor);
        }
        return materialList;
    }
}
