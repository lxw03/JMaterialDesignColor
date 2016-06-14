package com.dev.liji.materialdesigncolor.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dev.liji.materialdesigncolor.R;
import com.dev.liji.materialdesigncolor.adapter.FirstLayoutAdapter;
import com.dev.liji.materialdesigncolor.model.MaterialDesignColor;
import com.dev.liji.materialdesigncolor.widget.Headview;
import com.dev.liji.materialdesigncolor.widget.RecycleViewDivider;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends ActivityBase {


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
        headview.setTitle("MATERIAL");

        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerData.setLayoutManager(layoutManager);
        recyclerData.addItemDecoration(new RecycleViewDivider(MainActivity.this, LinearLayoutManager.VERTICAL));

    }

    @Override
    public void initData() {

        List<MaterialDesignColor> materialDesignColorList = getMaterialDesignColors();
        firstLayoutAdapter = new FirstLayoutAdapter(MainActivity.this, materialDesignColorList);
        recyclerData.setAdapter(firstLayoutAdapter);

    }

    @Override
    public int getLayoutViewId() {
        return R.layout.activity_main;
    }


    public List<MaterialDesignColor> getMaterialDesignColors() {
        String[] name = {"Red", "Pink", "Purple", "Deep Purple",
                "Indigo", "Blue", "Light Blue", "Cyan",
                "Teal", "Green", "Light Green", "Lime",
                "Yellow", "Amber", "Orange", "Deep Orange",
                "Brown", "Gray", "Blue Gray"};
        String[] value = {"#F44336", "#E91E63", "#9C27B0", "#673AB7",
                "#3F51B5", "#2196F3", "#03A9F4", "#00BCD4",
                "#009688", "#4CAF50", "#8BC34A", "#CDDC39",
                "#FFEB3B", "#FFC107", "#FF9800", "#FF5722",
                "#795548", "#9E9E9E", "#607D8B"};

        Integer[] mdColor = {Color.rgb(244, 67, 54)};


        List<MaterialDesignColor> materialDesignColors = new ArrayList<>();
        for (int i = 0; i < name.length; i++) {
            MaterialDesignColor color = new MaterialDesignColor();
            color.setMDColor(mdColor[0]);
            color.setName(name[i]);
            color.setLevel("500");
            color.setValue(value[i]);
            materialDesignColors.add(color);
        }
        return materialDesignColors;
    }
}
