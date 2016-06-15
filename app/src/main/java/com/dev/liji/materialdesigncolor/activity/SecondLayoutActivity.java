package com.dev.liji.materialdesigncolor.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.dev.liji.materialdesigncolor.R;
import com.dev.liji.materialdesigncolor.adapter.FirstLayoutAdapter;
import com.dev.liji.materialdesigncolor.adapter.SecondLayoutAdapter;
import com.dev.liji.materialdesigncolor.model.ColorFirstPattle;
import com.dev.liji.materialdesigncolor.model.MaterialDesignColor;
import com.dev.liji.materialdesigncolor.utils.JLogUtils;
import com.dev.liji.materialdesigncolor.widget.Headview;
import com.dev.liji.materialdesigncolor.widget.RecycleViewDivider;

import java.util.ArrayList;
import java.util.List;

public class SecondLayoutActivity extends ActivityBase {

    private Integer positionValue = 0;
    Headview headview;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;


    SecondLayoutAdapter secondLayoutAdapter;
    List<MaterialDesignColor> materialDesignColors = new ArrayList<>();
    private List<MaterialDesignColor> materialColorsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        headview = (Headview) findViewById(R.id.headview);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_data);

        headview.setBackClick(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        headview.setRightTextAction("预览", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondLayoutActivity.this, SecondLayoutHorizonalActivity.class);
                intent.putExtra("positionValue", "" + positionValue);
                startActivity(intent);
            }
        });

        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void initData() {
        positionValue = Integer.parseInt(this.getIntent().getStringExtra("pos"));
        JLogUtils.D("second: " + positionValue);
        headview.setTitle("" + ColorFirstPattle.nameFirst[positionValue]);
        headview.setBackgroundCustomeColor(ColorFirstPattle.mdColorFirst[positionValue]);
        materialDesignColors = getMaterialColorsList();
        secondLayoutAdapter = new SecondLayoutAdapter(SecondLayoutActivity.this, materialDesignColors);
        recyclerView.setAdapter(secondLayoutAdapter);
        secondLayoutAdapter.setOnItemClickListener(new SecondLayoutAdapter.onItemClickListener() {
            @Override
            public void onItemClick(View view, int posititon) {
                int pos = posititon;
                Intent intent = new Intent(SecondLayoutActivity.this, SecondLayoutDetailInfo.class);
                intent.putExtra("pos", "" + pos);
                intent.putExtra("positionValue", "" + positionValue);
                startActivity(intent);

            }
        });

    }

    @Override
    public int getLayoutViewId() {
        return R.layout.activity_second_layout;
    }

    public List<MaterialDesignColor> getMaterialColorsList() {
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
