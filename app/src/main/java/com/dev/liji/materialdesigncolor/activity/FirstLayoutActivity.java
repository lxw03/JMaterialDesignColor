package com.dev.liji.materialdesigncolor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.dev.liji.materialdesigncolor.R;
import com.dev.liji.materialdesigncolor.adapter.FirstLayoutAdapter;
import com.dev.liji.materialdesigncolor.model.ColorFirstPattle;
import com.dev.liji.materialdesigncolor.model.MaterialDesignColor;
import com.dev.liji.materialdesigncolor.widget.Headview;
import com.dev.liji.materialdesigncolor.widget.RecycleViewDivider;

import java.util.ArrayList;
import java.util.List;

public class FirstLayoutActivity extends ActivityBase {


    Headview headview;
    RecyclerView recyclerData;

    LinearLayoutManager layoutManager;
    FirstLayoutAdapter firstLayoutAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        headview = (Headview) findViewById(R.id.headview);
        recyclerData = (RecyclerView) findViewById(R.id.recycler_data);
        headview.setBackClick(null);
        headview.setTitle("Material Design Color");

        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerData.setLayoutManager(layoutManager);
        recyclerData.addItemDecoration(new RecycleViewDivider(FirstLayoutActivity.this, LinearLayoutManager.VERTICAL));

    }

    @Override
    public void initData() {

        List<MaterialDesignColor> materialDesignColorList = getMaterialDesignColors();
        firstLayoutAdapter = new FirstLayoutAdapter(FirstLayoutActivity.this, materialDesignColorList);
        recyclerData.setAdapter(firstLayoutAdapter);
        firstLayoutAdapter.setOnItemClickListener(new FirstLayoutAdapter.onItemClickListener() {
            @Override
            public void onItemClick(View view, int posititon) {

                Log.d("position: ", "" + posititon);
                Intent intent = new Intent(FirstLayoutActivity.this, SecondLayoutActivity.class);
                intent.putExtra("pos", "" + posititon);
                startActivity(intent);

            }
        });

    }

    @Override
    public int getLayoutViewId() {
        return R.layout.activity_main;
    }


    public List<MaterialDesignColor> getMaterialDesignColors() {

        List<MaterialDesignColor> materialDesignColors = new ArrayList<>();
        for (int i = 0; i < ColorFirstPattle.nameFirst.length; i++) {
            MaterialDesignColor color = new MaterialDesignColor();
            color.setMDColor(ColorFirstPattle.mdColorFirst[i]);
            color.setName(ColorFirstPattle.nameFirst[i]);
            color.setLevel("500");
            color.setValue(ColorFirstPattle.valueFirst[i]);
            materialDesignColors.add(color);
        }
        return materialDesignColors;
    }
}
